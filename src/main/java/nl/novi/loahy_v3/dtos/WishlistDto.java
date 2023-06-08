package nl.novi.loahy_v3.dtos;

import nl.novi.loahy_v3.models.Wishlist;

public class WishlistDto {

    public Integer wishlistId;

    public WishlistDto(Integer wishlistId) {
        this.wishlistId = wishlistId;
    }


    public Integer getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Integer wishlistId) {
        this.wishlistId = wishlistId;
    }

}
