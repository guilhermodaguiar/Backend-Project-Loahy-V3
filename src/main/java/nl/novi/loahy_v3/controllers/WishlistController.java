package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.ProductDto;
import nl.novi.loahy_v3.dtos.WishlistDto;
import nl.novi.loahy_v3.services.WishlistService;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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

    //hier moet een get request komen om alle producten te krijgen dat is opgeslagen in een bepaalde wishlist.

    @GetMapping("/products/{wishlistId}")
    public Collection<ProductDto> getProductsByWishlistId(@PathVariable("wishlistId") Integer wishlistId) {
        return wishlistService.getWishlistProductsByWishlistId(wishlistId);
    }

}