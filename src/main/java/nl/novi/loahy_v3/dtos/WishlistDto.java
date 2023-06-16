package nl.novi.loahy_v3.dtos;


import nl.novi.loahy_v3.models.Wishlist;

public class WishlistDto {

    public Integer wishlistId;

    public static WishlistDto fromWishlist(Wishlist wishlist) {

        var dto = new WishlistDto();

        dto.wishlistId = wishlist.getWishlistId();

        return dto;
    }

    public Integer getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Integer wishlistId) {
        this.wishlistId = wishlistId;
    }

}
