package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.WishlistDto;
import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;


    @Autowired
    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public List<WishlistDto> getAllWishlists() {
        List<WishlistDto> dtos = new ArrayList<>();
        List<Wishlist> wishlists = wishlistRepository.findAll();
        for(Wishlist wl : wishlists) {
            dtos.add(transferToWishlistDto(wl));
        }

        return dtos;
    }

    public WishlistDto getWishlist(Integer wishlistId) {
        Optional<Wishlist> wishlistOptional = wishlistRepository.findById(wishlistId);
        if(wishlistOptional.isPresent()) {
            return transferToWishlistDto(wishlistOptional.get());
        } else {
            throw new RecordNotFoundException("No wishlist found");
        }
    }

    public Wishlist saveWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public WishlistDto addWishlist(WishlistDto wishlistDto) {
        wishlistRepository.save(transferToWishlist(wishlistDto));
        return wishlistDto;
    }


    public Wishlist transferToWishlist(WishlistDto dto) {
        Wishlist wishlist = new Wishlist();

        wishlist.setWishlistId(dto.getWishlistId());

        return wishlist;
    }

    public WishlistDto transferToWishlistDto(Wishlist wishlist) {
        var dto = new WishlistDto();

        dto.wishlistId = wishlist.getWishlistId();

        return dto;
    }


}