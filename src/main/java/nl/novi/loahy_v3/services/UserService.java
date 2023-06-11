package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.UserDto;
import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.exceptions.UserEmailAlreadyExistException;
import nl.novi.loahy_v3.exceptions.UserEmailNotFoundException;
import nl.novi.loahy_v3.models.Authority;
import nl.novi.loahy_v3.models.Address;
import nl.novi.loahy_v3.models.User;
import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.repositories.AddressRepository;
import nl.novi.loahy_v3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private final AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private WishlistService wishlistService;



    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.addressRepository = addressRepository;
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for (User user : list) {
            collection.add(fromUser(user));
        }
        return collection;
    }


    public UserDto getUser(String userEmail) {
        UserDto userDto = new UserDto();
        Optional<User> user = userRepository.findById(userEmail);
        if (user.isPresent()) {
            userDto = fromUser(user.get());
        } else {
            throw new UserEmailNotFoundException(userEmail);
        }
        return userDto;
    }

    public boolean userExist(String userEmail) {
        return userRepository.existsById(userEmail);
    }


    public String createUser(UserDto userDto) {

        if (userExist(userDto.getUserEmail())) {
            throw new UserEmailAlreadyExistException("Username is al in gebruik!");
        }
        User newUser = userRepository.save(toUser(userDto));

        newUser.setUserId((long) ((getAllUsers().size()) + 1));
        newUser.setUserEmail(userDto.getUserEmail());
        newUser.setPassword(passwordEncoder.encode(userDto.password));
        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());

        newUser.setAddress(addressService.saveAddress(new Address()));
        newUser.setWishlist(wishlistService.saveWishlist(new Wishlist()));

        userRepository.save(newUser);
        return newUser.getUserEmail();
    }

    public void updateUser(String userEmail, UserDto newUser) {
        if (!userRepository.existsById(userEmail))
            throw new UserEmailNotFoundException(userEmail);

        User user = userRepository.findById(userEmail).get();
        user.setPassword(passwordEncoder.encode(newUser.password));
        userRepository.save(user);
    }

    public void deleteUser(String userEmail) {
        userRepository.deleteById(userEmail);
    }


    public void addAuthority(String userEmail, String authority) {

        if (!userRepository.existsById(userEmail)) throw new UserEmailNotFoundException(userEmail);
        User user = userRepository.findById(userEmail).get();
        user.addAuthority(new Authority(userEmail, authority));
        userRepository.save(user);
    }

    public void assignAddressToUser(Long addressId, String userEmail) {

        Optional<User> optionalUser = userRepository.findById(userEmail);
        Optional<Address> optionalCustomer = addressRepository.findById(addressId);

        if (optionalCustomer.isPresent() && optionalUser.isPresent()) {
            User user = optionalUser.get();
            Address address = optionalCustomer.get();

            user.setAddress(address);
            userRepository.save(user);
        } else {
            throw new RecordNotFoundException();
        }
    }


    public static UserDto fromUser(User user){

        var dto = new UserDto();

        dto.userEmail = user.getUserEmail();
        dto.password = user.getPassword();
        dto.enabled = user.isEnabled();
        dto.authorities = user.getAuthorities();

        dto.firstName = user.getFirstName();
        dto.lastName = user.getLastName();
        dto.userId = user.getUserId();

        dto.address = user.getAddress();
        dto.wishlist = user.getWishlist();

        return dto;
    }

    public User toUser(UserDto userDto) {

        var user = new User();

        user.setUserEmail(userDto.getUserEmail());
        user.setPassword(userDto.getPassword());
        user.setEnabled(userDto.getEnabled());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());

        return user;
    }
}
