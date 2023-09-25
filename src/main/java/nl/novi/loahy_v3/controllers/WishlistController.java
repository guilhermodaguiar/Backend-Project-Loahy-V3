package nl.novi.loahy_v3.controllers;

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

    private final WishlistService wishlistService;

    @Autowired
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }


    @GetMapping(value = "/products")
    public ResponseEntity<List<Wishlist>> findALlWishlists() {
        return ResponseEntity.ok().body(wishlistService.getAllWishlists());
    }


    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Wishlist> findWishlistById(@PathVariable("id") Integer wishlistId) {
        return ResponseEntity.ok().body(wishlistService.getWishlistById(wishlistId));
    }


    @PutMapping(value = "/{wishlistId}/{productId}")
    public ResponseEntity<Wishlist> assignProductToWishlist(@PathVariable Integer wishlistId, @PathVariable Integer productId) {
        return ResponseEntity.ok().body(wishlistService.assignProductToWishlist(wishlistId, productId));
    }

    @DeleteMapping(value = "/{wishlistId}/{productId}")
    public ResponseEntity<Wishlist> removeProductFromWishlist(@PathVariable Integer wishlistId, @PathVariable Integer productId) {
        wishlistService.removeProductFromWishlist(wishlistId, productId);
        return ResponseEntity.noContent().build();
    }
}