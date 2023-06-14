package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.WishlistDto;
import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.services.ProductService;
import nl.novi.loahy_v3.services.WishlistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/wishlist/products")
public class WishlistProductController {


    private final WishlistService wishlistService;

    private final ProductService productService;

    public WishlistProductController(WishlistService wishlistService, ProductService productService) {
        this.wishlistService = wishlistService;
        this.productService = productService;
    }


    @GetMapping(value = "/wishlist/all")
    public List<WishlistDto> findALlWishlists(){

        return wishlistService.getAllWishlists();
    }

//    @PostMapping(value = "/save")
//    public Wishlist saveWishlistWithProducts(@RequestBody Wishlist wishlist){
//        return  wishlistRepository.save(wishlist);
//    }

    @GetMapping("/{id}")
    public WishlistDto findWishlist(@PathVariable("id") Integer wishlistId){

        WishlistDto wishlistDto = wishlistService.getWishlist(wishlistId);

        return wishlistDto;
    }

}
