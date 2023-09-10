package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.UserDto;
import nl.novi.loahy_v3.dtos.UserPasswordOnlyDto;
import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.exceptions.UserEmailAlreadyExistException;
import nl.novi.loahy_v3.exceptions.UserEmailNotFoundException;
import nl.novi.loahy_v3.models.Address;
import nl.novi.loahy_v3.models.Authority;
import nl.novi.loahy_v3.models.User;
import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.repositories.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static nl.novi.loahy_v3.dtos.UserDto.fromUser;

@Service
public class UserService {


    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;


    private final AddressService addressService;


    private final WishlistService wishlistService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AddressService addressService, WishlistService wishlistService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.addressService = addressService;
        this.wishlistService = wishlistService;
    }


    public List<UserDto> getAllUsers() {
        List<User> list = userRepository.findAll();
        List<UserDto> collection = new ArrayList<>();
        for (User user : list) {
            collection.add(fromUser(user));
        }
        return collection;
    }

    public UserDto getByUserEmail(String username) {
        UserDto dto = new UserDto();
        Optional<User> user = userRepository.findUserByUserEmailIs(username);
        if (user.isPresent()) {
            dto = fromUser(user.get());
        } else {
            throw new UsernameNotFoundException(username);
        }
        return dto;
    }


    public boolean userExist(String userEmail) {
        return userRepository.existsById(userEmail);
    }


    public String createUser(User user) {

        if (userExist(user.getUserEmail())) {
            throw new UserEmailAlreadyExistException("Email is al in gebruik!");
        }

        user.setUserId((long) ((getAllUsers().size()) + 1));
        user.setUserEmail(user.getUserEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());

        user.setAddress(addressService.saveAddress(new Address()));
        user.setWishlist(wishlistService.saveWishlist(new Wishlist()));

        User newUser = userRepository.save(user);
        userRepository.save(newUser);
        return newUser.getUserEmail();
    }


    public void updatePassword(String userEmail, UserPasswordOnlyDto user) {
        if (!userRepository.existsById(userEmail)) {
            throw new UserEmailNotFoundException(userEmail);
        } else {
            User user1 = userRepository.findById(userEmail).get();
            user1.setPassword(passwordEncoder.encode(user.getPassword()));

            userRepository.save(user1);
        }
    }


    public void deleteUser(String userEmail) {
        if (!userRepository.existsById(userEmail)) {
            throw new RecordNotFoundException("User met email bestaat niet");
        }
        userRepository.deleteById(userEmail);
    }


    public void addAuthority(String userEmail, String authority) {

        if (!userRepository.existsById(userEmail)) throw new UserEmailNotFoundException(userEmail);
        User user = userRepository.findById(userEmail).get();
        user.addAuthority(new Authority(userEmail, authority));
        userRepository.save(user);
    }

}