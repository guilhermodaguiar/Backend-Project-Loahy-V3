package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.ProductDto;
import nl.novi.loahy_v3.dtos.UserDto;
import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.models.Address;
import nl.novi.loahy_v3.models.Product;
import nl.novi.loahy_v3.models.User;
import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.repositories.AddressRepository;
import nl.novi.loahy_v3.repositories.WishlistRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WishlistServiceTest {

    @Mock
    private WishlistRepository wishlistRepository;

    @InjectMocks
    private WishlistService wishlistService;


    @Test
    @DisplayName("Should return the wishlist when the wishlist exists")
    void getWishlistWhenWishlistExists() {
        Wishlist wishlist = new Wishlist();
        wishlist.setWishlistId(100);
        wishlist.setProducts(new HashSet<>());


        when(wishlistRepository.findById(100)).thenReturn(Optional.of(wishlist));

        Wishlist result = wishlistService.getWishlistById(100);

        assertEquals(wishlist, result);
    }

    @Test
    @DisplayName("Should returns all wishlists")
    void getWishlistsShouldReturnsAllWishlists() {
        Wishlist wishlist = new Wishlist();
        wishlist.setWishlistId(1);
        wishlist.setProducts(new HashSet<>());

        when(wishlistRepository.findAll()).thenReturn(List.of(wishlist));

        List<Wishlist> wishlists = wishlistService.getAllWishlists();

        assertNotNull(wishlists);
        assertFalse(wishlists.isEmpty());
        assertEquals(1, wishlists.size());

        verify(wishlistRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should throw an exception when the wishlist does not exist")
    void getWishlistWhenWishlistDoesNotExistThenThrowException() {
        when(wishlistRepository.findById(100)).thenReturn(Optional.empty());

        assertThrows(RecordNotFoundException.class, () -> wishlistService.getWishlistById(100));

        verify(wishlistRepository, times(1)).findById(100);
    }
}
