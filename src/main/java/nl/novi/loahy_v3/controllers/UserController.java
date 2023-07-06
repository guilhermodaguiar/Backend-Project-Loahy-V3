package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.models.User;
import nl.novi.loahy_v3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<Object> getAllUsers() {

        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getByUserEmail(@PathVariable("id") String username) {

        return ResponseEntity.ok().body(userService.getByUserEmail(username));

    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        String newUserEmail = userService.createUser(user);
        userService.addAuthority(newUserEmail, "ROLE_USER");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{email}")
                .buildAndExpand(newUserEmail).toUri();

        return ResponseEntity
                .created(location)
                .build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable("id") String userEmail, @RequestBody User user) {

        userService.updateUser(userEmail, user);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") String userEmail) {
        userService.deleteUser(userEmail);
        return ResponseEntity.noContent().build();
    }
}
