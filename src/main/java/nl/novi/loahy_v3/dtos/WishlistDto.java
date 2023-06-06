package nl.novi.loahy_v3.dtos;

import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.models.WishlistProduct;

public class WishlistDto {

    public Integer wishlistId;

    public ProductDto productDto;

    public WishlistProduct wishlistProduct;


    public static WishlistDto transferToWishlistDto(Wishlist wishlist) {

        var wishlistDto = new WishlistDto();

        wishlistDto.wishlistId = wishlist.getWishlistId();


        return wishlistDto;
    }


    public Integer getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Integer wishlistId) {
        this.wishlistId = wishlistId;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public WishlistProduct getWishlistProduct() {
        return wishlistProduct;
    }

    public void setWishlistProduct(WishlistProduct wishlistProduct) {
        this.wishlistProduct = wishlistProduct;
    }
}
