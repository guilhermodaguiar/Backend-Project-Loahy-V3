package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.UserDto;
import nl.novi.loahy_v3.exceptions.UserEmailAlreadyExistException;
import nl.novi.loahy_v3.exceptions.UserEmailNotFoundException;
import nl.novi.loahy_v3.models.Authority;
import nl.novi.loahy_v3.models.Customer;
import nl.novi.loahy_v3.models.User;
import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.repositories.CustomerRepository;
import nl.novi.loahy_v3.repositories.UserRepository;
import nl.novi.loahy_v3.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static nl.novi.loahy_v3.dtos.UserDto.fromUser;


@Service
public class UserService {

    private final UserRepository userRepository;

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    private final WishlistRepository wishlistRepository;


    @Autowired
    public UserService(UserRepository userRepository, CustomerRepository customerRepository, PasswordEncoder passwordEncoder, WishlistRepository wishlistRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.wishlistRepository = wishlistRepository;
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for (User user : list) {
            collection.add(fromUser(user));
        }
        return collection;
    }


    public UserDto getUserByUserEmail(String userEmail) {
        new UserDto();
        UserDto userDto;
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
            throw new UserEmailAlreadyExistException(userDto.userEmail);
        }
        User newUser = userRepository.save(toUser(userDto));
        newUser.setUserPassword(passwordEncoder.encode(userDto.password));

        userRepository.save(newUser);
        return newUser.getUserEmail();
    }

    public void updateUser(String userEmail, UserDto newUser) {
        if (!userRepository.existsById(userEmail)) throw new UserEmailNotFoundException(userEmail);
        User user = userRepository.findById(userEmail).get();
        user.setUserPassword(passwordEncoder.encode(newUser.password));
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


    public User toUser(UserDto userDto) {

        var user = new User();

        user.setUserPassword(userDto.getUserPassword());
        user.setUserEmail(userDto.getUserEmail());
        return user;
    }

    public UserDto transferToDto(User user) {

        var userDto = new UserDto();

        userDto.userEmail = user.getUserEmail();
        userDto.password = user.getUserPassword();

        return userDto;
    }


    public void assignCustomerToUser(Long customerId, String userEmail) {

        Optional<User> optionalUser = userRepository.findById(userEmail);
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isPresent() && optionalUser.isPresent()) {
            User user = optionalUser.get();
            Customer customer = optionalCustomer.get();

            user.setCustomer(customer);
            userRepository.save(user);
        }
    }

    public void registerCustomerToUser(Long customerId, String userEmail) {

        Optional<User>optionalUser = userRepository.findUserByUserEmailIs(userEmail);
        Optional<Customer> optionalCustomer = customerRepository.findByCustomerId(customerId);

        if (optionalCustomer.isPresent() && optionalUser.isPresent()) {
            User user = optionalUser.get();
            Customer customer = optionalCustomer.get();

            user.setCustomer(customer);
            userRepository.save(user);
        } else {
            throw new UserEmailNotFoundException(userEmail);
        }
    }

    public void addWishlistToUser(Integer wishlistId, String userEmail) {

        Optional<User>optionalUser = userRepository.findUserByUserEmailIs(userEmail);
        Optional<Wishlist> optionalWishlist = wishlistRepository.findByWishlistId(wishlistId);

        if (optionalWishlist.isPresent() && optionalUser.isPresent()) {
            User user = optionalUser.get();
            Wishlist wishlist = optionalWishlist.get();

            user.setWishlist(wishlist);
            userRepository.save(user);
        } else {
            throw new UserEmailNotFoundException(userEmail);
        }
    }
}
