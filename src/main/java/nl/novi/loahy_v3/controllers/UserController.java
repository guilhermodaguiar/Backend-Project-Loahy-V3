package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.CustomerDto;
import nl.novi.loahy_v3.dtos.UserDto;
import nl.novi.loahy_v3.dtos.WishlistDto;
import nl.novi.loahy_v3.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {


    private final UserService userService;

    private final CustomerController customerController;

    private final WishlistController wishlistController;


    public UserController(UserService userService, CustomerController customerController, WishlistController wishlistController) {
        this.userService = userService;
        this.customerController = customerController;
        this.wishlistController = wishlistController;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {

        List<UserDto> userDtos = userService.getAllUsers();

        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping(value = "/{user_email}")
    public ResponseEntity<UserDto> getUserByUserEmail(@PathVariable("user_email") String userEmail) {

        UserDto optionalUser = userService.getUserByUserEmail(userEmail);

        return ResponseEntity.ok().body(optionalUser);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

        String newUserEmail = userService.createUser(userDto);
        userService.addAuthority(newUserEmail, "ROLE_USER");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{user-email}/")
                .buildAndExpand(newUserEmail).toUri();

        return ResponseEntity
                .created(location)
                .build();
    }

    @PutMapping(value = "/{user_email}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("user_email") String userEmail, @RequestBody UserDto userDto) {

        userService.updateUser(userEmail, userDto);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = "/delete/{user_email}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable("user_email") String userEmail) {
        userService.deleteUser(userEmail);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{user_email}/{customerId}")
    public void assignCustomerToUser(@PathVariable("user_email") String userEmail,
                                   @PathVariable("customerId") Long customerId) {

        userService.assignCustomerToUser(customerId, userEmail);

    }

    @PostMapping("/{user_email}/customer")
    public void registerCustomerToUser(@PathVariable("user_email") String userEmail,
                                     @RequestBody CustomerDto Dto) {

        ResponseEntity <CustomerDto> customerData = customerController.createCustomer(Dto);

        assert customerData != null;
        userService.registerCustomerToUser(Objects.requireNonNull(customerData.getBody()).getCustomerId(), userEmail);
    }

    @PostMapping("/{user_email}/wishlist")
    public void addWishlistToUser(@PathVariable("user_email") String userEmail,
                                       @RequestBody WishlistDto Dto) {

        ResponseEntity <WishlistDto> wishlistData = wishlistController.createWishlist(Dto);


        assert wishlistData != null;
        userService.addWishlistToUser(Objects.requireNonNull(wishlistData.getBody()).getWishlistId(), userEmail);
    }

}
