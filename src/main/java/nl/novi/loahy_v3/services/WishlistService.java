package nl.novi.loahy_v3.services;


import nl.novi.loahy_v3.dtos.WishlistDto;
import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static nl.novi.loahy_v3.dtos.WishlistDto.transferToWishlistDto;

@Service
public class WishlistService {
    
    private final WishlistRepository wishlistRepository;


    @Autowired
    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }



    public WishlistDto createWishlist(WishlistDto wishlistDto) {


        Wishlist newWishlist =  transferToWishlist(wishlistDto);
        wishlistRepository.save(newWishlist);
        return transferToWishlistDto(newWishlist);
    }


    public WishlistDto updateWishlist(Integer wishlistId, WishlistDto wishlistDto) {
        if (wishlistRepository.findById(wishlistId).isPresent()) {

            Wishlist wishlist = wishlistRepository.findById(wishlistId).get();

            Wishlist wishlist1 = transferToWishlist(wishlistDto);
            wishlist1.setWishlistName(wishlist.getWishlistName());

            wishlistRepository.save(wishlist1);

            return transferToWishlistDto(wishlist1);
        } else {
            throw new RecordNotFoundException("wishlist id niet gevonden");
        }
    }

    public void deleteWishlistById( Integer wishlistId) {

        wishlistRepository.deleteById(wishlistId);
    }



    public Wishlist transferToWishlist(WishlistDto Dto) {

        var wishlist = new Wishlist();

        wishlist.setWishlistId(Dto.getWishlistId());
        wishlist.setWishlistName(Dto.getWishlistName());
        return wishlist;
    }

}
