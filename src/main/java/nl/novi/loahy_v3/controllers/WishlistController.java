package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.models.Product;
import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/wishlists")
public class WishlistController {

    @Autowired
    private final WishlistService wishlistService;

    @Autowired
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }


    @GetMapping(value = "/products/all")
    public List<Wishlist> findALlWishlists() {
        return wishlistService.getAllWishlists();
    }


    @GetMapping(value = "/products/{id}")
    public Wishlist findWishlistById(@PathVariable("id") Integer wishlistId) {
        return wishlistService.getWishlistById(wishlistId);
    }


    @PutMapping(value = "/{wishlistId}/{productId}")
    public Wishlist assignProductToWishlist(@PathVariable Integer wishlistId, @PathVariable Integer productId) {
        return wishlistService.assignProductToWishlist(wishlistId, productId);
    }

    @DeleteMapping(value ="/{wishlistId}/{productId}")
    public Wishlist removeProductFromWishlist(@PathVariable Integer wishlistId, @PathVariable Integer productId) {
        return wishlistService.removeProductFromWishlist(wishlistId, productId);
    }

}