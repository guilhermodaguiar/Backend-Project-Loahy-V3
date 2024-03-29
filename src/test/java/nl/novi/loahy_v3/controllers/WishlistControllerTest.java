package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.services.WishlistService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WishlistControllerTest {

    @Mock
    private WishlistService wishlistService;

    @InjectMocks
    private WishlistController wishlistController;


    @Test
    @DisplayName("Should return the wishlist when the id is valid")
    void getWishlistWhenIdIsValid() {
        Wishlist wishlist = new Wishlist();
        wishlist.setWishlistId((1));
        wishlist.setProducts(new HashSet<>());

        when(wishlistService.getWishlistById(1)).thenReturn(wishlist);

        Wishlist result = wishlistController.findWishlistById(1).getBody();

        assertNotNull(result);
        assertEquals(1, result.getWishlistId());
        assertEquals(new HashSet<>(), result.getProducts());
    }
}
