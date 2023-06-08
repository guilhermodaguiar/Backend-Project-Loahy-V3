package nl.novi.loahy_v3.services;


import nl.novi.loahy_v3.dtos.ProductDto;
import nl.novi.loahy_v3.dtos.WishlistDto;
import nl.novi.loahy_v3.models.Product;
import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;


    @Autowired
    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }


    public Wishlist saveWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public WishlistDto addWishlist(WishlistDto wishlistDto) {
        wishlistRepository.save(transferToWishlist(wishlistDto));
        return wishlistDto;
    }

    // hier moet een getProductsByWishlistId komen te staan.
    //liefs als een list of een collection.
    //findWishlistId.

    public Wishlist transferToWishlist(WishlistDto dto) {
        Wishlist wishlist = new Wishlist();

        wishlist.setWishlistId(dto.getWishlistId());

        return wishlist;
    }
}