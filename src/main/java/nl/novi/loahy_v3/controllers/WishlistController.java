package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.WishlistDto;
import nl.novi.loahy_v3.services.WishlistService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/wishlists")
public class WishlistController {

    private final WishlistService wishlistService;



    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }



    @PostMapping(value = "/add-wishlist")
    public WishlistDto addWishlist(@RequestBody WishlistDto dto) {
        return wishlistService.addWishlist(dto);
    }

}