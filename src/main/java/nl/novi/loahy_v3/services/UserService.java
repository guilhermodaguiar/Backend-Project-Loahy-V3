package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.models.User;
import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.exceptions.UserEmailAlreadyExistException;
import nl.novi.loahy_v3.exceptions.UserEmailNotFoundException;
import nl.novi.loahy_v3.models.Address;
import nl.novi.loahy_v3.models.Authority;
import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.repositories.AddressRepository;
import nl.novi.loahy_v3.repositories.UserRepository;
import nl.novi.loahy_v3.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
    private final WishlistRepository wishlistRepository;
    @Autowired
    private WishlistService wishlistService;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AddressRepository addressRepository, WishlistRepository wishlistRepository, WishlistService wishlistService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.addressRepository = addressRepository;
        this.wishlistRepository = wishlistRepository;
        this.wishlistService = wishlistService;
    }


    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }


    public Optional<User> getByUserEmail(String username) {
        return userRepository.findById(username);
    }

    public boolean userExist(String userEmail) {
        return userRepository.existsById(userEmail);
    }


    public String createUser(User user) {

        if (userExist(user.getUserEmail())) {
            throw new UserEmailAlreadyExistException("Username is al in gebruik!");
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

    //Hier gebleven
    public void updateUser(String userEmail, User user) {
        if (!userRepository.existsById(userEmail))
            throw new UserEmailNotFoundException(userEmail);

        User user1 = userRepository.findById(userEmail).get();
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user1);
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
        Optional<Address> optionalAddress = addressRepository.findById(addressId);

        if (optionalAddress.isPresent() && optionalUser.isPresent()) {
            User user = optionalUser.get();
            Address address = optionalAddress.get();

            user.setAddress(address);
            userRepository.save(user);
        } else {
            throw new RecordNotFoundException();
        }
    }

    public void assignWishlistToUser(Integer wishlistId, String userEmail) {

        Optional<User> optionalUser = userRepository.findById(userEmail);
        Optional<Wishlist> optionalWishlist = wishlistRepository.findById(wishlistId);

        if (optionalWishlist.isPresent() && optionalUser.isPresent()) {
            User user = optionalUser.get();
            Wishlist wishlist = optionalWishlist.get();

            user.setWishlist(wishlist);
            userRepository.save(user);
        } else {
            throw new RecordNotFoundException();
        }
    }
}
