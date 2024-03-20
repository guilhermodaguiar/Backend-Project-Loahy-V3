package nl.loahy_v3.service;

import lombok.AllArgsConstructor;
import nl.loahy_v3.exceptions.UserEmailAlreadyExistException;
import nl.loahy_v3.repository.UserRepository;
import nl.loahy_v3.dto.UserDto;
import nl.loahy_v3.dto.UserPasswordOnlyDto;
import nl.loahy_v3.exceptions.RecordNotFoundException;
import nl.loahy_v3.exceptions.UserEmailNotFoundException;
import nl.loahy_v3.model.Address;
import nl.loahy_v3.model.Authority;
import nl.loahy_v3.model.User;
import nl.loahy_v3.model.Wishlist;
import nl.loahy_v3.utils.RandomStringGenerator;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static nl.loahy_v3.dto.UserDto.fromUser;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AddressService addressService;
    private final WishlistService wishlistService;


    public List<UserDto> getAllUsers() {
        List<User> list = userRepository.findAll();
        List<UserDto> collection = new ArrayList<>();
        for (User user : list) {
            collection.add(fromUser(user));
        }
        return collection;
    }


    public UserDto getUser(String email) {
        UserDto dto = new UserDto();
        Optional<User> user = userRepository.findById(email);
        if (user.isPresent()) {
            dto = fromUser(user.get());
        } else {
            throw new UsernameNotFoundException("user met id "+ email + " niet gevonden");
        }
        return dto;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Note> findById(@PathVariable int id)
//    {
//        User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Note note=noteService.findById(id);
//        if(note.getUser().getId()==user.getId())
//            return new ResponseEntity<>(note,HttpStatus.OK);
//        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//    }

    public boolean userExist(String email) {
        return userRepository.existsById(email);
    }


    public String createUser(UserDto dto) {

        if (userExist(dto.getEmail())) {
            throw new UserEmailAlreadyExistException("Email is al in gebruik!");
        }
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        dto.setApikey(randomString);
        User newUser = userRepository.save(toUser(dto));
        return newUser.getEmail();
    }


    public void updatePassword(String email, UserPasswordOnlyDto user) {
        if (!userRepository.existsById(email)) {
            throw new UserEmailNotFoundException(email);
        } else {
            User user1 = userRepository.findById(email).get();
            user1.setPassword(passwordEncoder.encode(user.getPassword()));

            userRepository.save(user1);
        }
    }


    public void deleteUser(String email) {
        if (!userRepository.existsById(email)) {
            throw new RecordNotFoundException("User met email "+ email + " bestaat niet");
        }
        userRepository.deleteById(email);
    }


    public void addAuthority(String email, String authority) {

        if (!userRepository.existsById(email)) throw new UserEmailNotFoundException(email);
        User user = userRepository.findById(email).get();
        user.addAuthority(new Authority(email, authority));
        userRepository.save(user);
    }

    public User toUser(UserDto dto) {

        var user = new User();

        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setApikey(dto.getApikey());
        user.setUserId((long) ((getAllUsers().size()) + 1));

        user.setAddress(addressService.saveAddress(new Address()));
        user.setWishlist(wishlistService.saveWishlist(new Wishlist()));

        return user;
    }

}