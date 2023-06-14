package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.WishlistDto;
import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.repositories.WishlistRepository;
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

    private final WishlistRepository wishlistRepository;

    public WishlistProductController(WishlistService wishlistService, ProductService productService, WishlistRepository wishlistRepository) {
        this.wishlistService = wishlistService;
        this.productService = productService;
        this.wishlistRepository = wishlistRepository;
    }


    @GetMapping(value = "/all")
    public List<WishlistDto> findALlWishlists(){

        return wishlistService.getAllWishlists();
    }


    @GetMapping("/{id}")
    public WishlistDto findWishlist(@PathVariable("id") Integer wishlistId){

        WishlistDto wishlistDto = wishlistService.getWishlist(wishlistId);

        return wishlistDto;
    }


    @GetMapping(value = "/test/all")
    public List<Wishlist> findALlStudents(){
        return wishlistRepository.findAll();
    }

    @GetMapping("/test/{wishlistId}")
    public Wishlist findWishlistById(@PathVariable() Integer wishlistId){
        return wishlistRepository.findById(wishlistId).orElse(null);
    }

}
