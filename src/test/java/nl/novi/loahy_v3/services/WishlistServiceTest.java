package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.models.Address;
import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.repositories.AddressRepository;
import nl.novi.loahy_v3.repositories.WishlistRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class WishlistServiceTest {

    @Mock
    private WishlistRepository wishlistRepository;

    @InjectMocks
    private WishlistService wishlistService;



    //Should throw an exception when product does not exist

    //Should throw an exception when wishlistId does not exist

}
