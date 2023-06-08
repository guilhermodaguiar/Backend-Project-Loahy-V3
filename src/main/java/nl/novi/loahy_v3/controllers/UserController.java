package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.UserDto;
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
    public ResponseEntity<List<UserDto>> getAllUsers() {

        List<UserDto> userDtos = userService.getAllUsers();

        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping(value = "/{email}")
    public ResponseEntity<UserDto> getUserByUserEmail(@PathVariable("email") String userEmail) {

        UserDto optionalUser = userService.getUser(userEmail);

        return ResponseEntity.ok().body(optionalUser);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

        String newUserEmail = userService.createUser(userDto);
        userService.addAuthority(newUserEmail, "ROLE_USER");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{email}")
                .buildAndExpand(newUserEmail).toUri();

        return ResponseEntity
                .created(location)
                .build();
    }

    @PutMapping(value = "/{email}")
    public ResponseEntity<Object> updateUser(@PathVariable("email") String userEmail, @RequestBody UserDto userDto) {

        userService.updateUser(userEmail, userDto);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = "/delete/{email}")
    public ResponseEntity<Object> deleteUser(@PathVariable("email") String userEmail) {
        userService.deleteUser(userEmail);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{user_email}/{customerId}")
    public void assignCustomerToUser(@PathVariable("user_email") String userEmail,
                                     @PathVariable("customerId") Long customerId) {

        userService.assignCustomerToUser(customerId, userEmail);

    }
}
