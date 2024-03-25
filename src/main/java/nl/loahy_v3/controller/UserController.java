package nl.loahy_v3.controller;

import lombok.AllArgsConstructor;
import nl.loahy_v3.dto.UserDto;
import nl.loahy_v3.dto.UserPasswordOnlyDto;
import nl.loahy_v3.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") String email) {
        return ResponseEntity.ok().body(userService.getUser(email));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdateUserPassword(@PathVariable("id") String email,
                                                       @RequestBody @Valid UserPasswordOnlyDto dto) {
        userService.updatePassword(email, dto);
        return ResponseEntity.ok("password updated");
    }


    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto dto) {
        String newUsername = userService.createUser(dto);
        userService.addAuthority(newUsername, "ROLE_USER");
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{email}")
                .buildAndExpand(newUsername)
                .toUri();
        return ResponseEntity.created(location)
                .build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") String email) {
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }
}
