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


    @GetMapping("/products/{id}")
    public Wishlist findWishlistById(@PathVariable("id") Integer wishlistId) {
        return wishlistService.getWishlistById(wishlistId);
    }


    // even testen.. beide postmapping en putmapping werken. producten kunnen worden toegevoegd aan wishlist.

    @PostMapping(value = "/{id}/{productId}")
    public ResponseEntity<Wishlist> addProductToWishlist(@PathVariable("id") Integer wishlistId, @PathVariable Product productId) {
        return ResponseEntity.ok(wishlistService.addProductToWishlist(wishlistId, productId));
    }


    @PutMapping("/{wishlistId}/{productId}")
    public Wishlist assignProductToWishlist(@PathVariable Integer wishlistId, @PathVariable Integer productId
    ){
        return wishlistService.assignProductToWishlist(wishlistId, productId);
    }

}