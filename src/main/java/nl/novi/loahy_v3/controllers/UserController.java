package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.UserDto;
import nl.novi.loahy_v3.dtos.UserPasswordOnlyDto;
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
    public ResponseEntity<Object> getUser(@PathVariable("id") String email) {

        return ResponseEntity.ok().body(userService.getUser(email));

    }


    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto dto) {

        String newUsername = userService.createUser(dto);

        userService.addAuthority(newUsername, "ROLE_USER");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{email}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity
                .created(location)
                .build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") String email) {
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdateUserPassword(@PathVariable("id") String email,
                                                       @RequestBody @Valid UserPasswordOnlyDto dto) {

        userService.updatePassword(email, dto);
        return ResponseEntity.ok("password updated");
    }
}
