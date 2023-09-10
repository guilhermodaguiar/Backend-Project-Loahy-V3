package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.UserPasswordOnlyDto;
import nl.novi.loahy_v3.models.User;
import nl.novi.loahy_v3.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<Object> getAllUsers() {

        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getByUserEmail(@PathVariable("id") String username) {

        return ResponseEntity.ok().body(userService.getByUserEmail(username));

    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {

        String newUserEmail = userService.createUser(user);
        userService.addAuthority(newUserEmail, "ROLE_USER");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{email}")
                .buildAndExpand(newUserEmail).toUri();

        return ResponseEntity
                .created(location)
                .build();
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") String userEmail) {
        userService.deleteUser(userEmail);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdateUserPassword(@PathVariable("id") String userEmail,
                                                       @RequestBody @Valid UserPasswordOnlyDto dto) {

        userService.updatePassword(userEmail, dto);
        return ResponseEntity.ok("password updated");
    }
}
