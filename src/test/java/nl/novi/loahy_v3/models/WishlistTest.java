package nl.novi.loahy_v3.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WishlistTest {

    @Test
    @DisplayName("should set the wishlist id")
    void setWishlistId() {
        Wishlist wishlist = new Wishlist();
        wishlist.setWishlistId(100);
        assertEquals(100, wishlist.getWishlistId());
    }
}
