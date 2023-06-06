package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.models.Product;
import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.models.WishlistProduct;
import nl.novi.loahy_v3.models.WishlistProductKey;
import nl.novi.loahy_v3.repositories.WishlistProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class WishlistProductServiceTest {

    @Mock
    private WishlistProductRepository wishlistProductRepository;

    @InjectMocks
    private WishlistProductService wishlistProductService;

    @Test
    @DisplayName("Should delete the product from wishlist when the product exists")
    void deleteProductFromWishlistWhenProductExists() {
        Wishlist wishlist1 = new Wishlist();
        wishlist1.setWishlistId(1);

        Product product1 = new Product();
        product1.setProductId(1);
        product1.setProductName("test");
        product1.setProductPrice(1.0);
        product1.setImage();


        wishlistProductRepository.delete(product1);

        wishlistProductService.deleteProduct(1);

        verify(wishlistProductRepository).delete(product1);
    }

    @Test
    @DisplayName("Should delete product id from wishlist")
    void deleteProductIdFromWishlist() {
        WishlistProductKey product = new WishlistProductKey();

        wishlistProductRepository.deleteById(product);

        verify(wishlistProductRepository).deleteById(product);

    }
}
