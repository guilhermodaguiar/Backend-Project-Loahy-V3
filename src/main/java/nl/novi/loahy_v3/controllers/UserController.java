package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.models.User;
import nl.novi.loahy_v3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/all")
    public ResponseEntity<Object> getAllUsers() {

        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping(value = "/{email}")
    public ResponseEntity<Object> getByUserEmail(@PathVariable("email") String username) {

        return ResponseEntity.ok().body(userService.getByUserEmail(username));

    }

    @PostMapping(value = "/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        String newUserEmail = userService.createUser(user);
        userService.addAuthority(newUserEmail, "ROLE_USER");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{email}")
                .buildAndExpand(newUserEmail).toUri();

        return ResponseEntity
                .created(location)
                .build();
    }

    @PutMapping(value = "/{email}")
    public ResponseEntity<Object> updateUser(@PathVariable("email") String userEmail, @RequestBody User user) {

        userService.updateUser(userEmail, user);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = "/delete/{email}")
    public ResponseEntity<Object> deleteUser(@PathVariable("email") String userEmail) {
        userService.deleteUser(userEmail);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{user_email}/{addressId}")
    public void assignAddressToUser(@PathVariable("user_email") String userEmail,
                                    @PathVariable("addressId") Long addressId) {

        userService.assignAddressToUser(addressId, userEmail);
    }

    @PutMapping(value = "/{user_email}/{wishlistId}")
    public void assignWishlistToUser(@PathVariable("user_email") String userEmail,
                                     @PathVariable("wishlistId") Integer wishlistId) {

        userService.assignWishlistToUser(wishlistId, userEmail);
    }
}
