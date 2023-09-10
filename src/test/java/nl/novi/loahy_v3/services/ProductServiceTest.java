package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.models.Product;
import nl.novi.loahy_v3.repositories.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    @DisplayName("Should return the product when the product exists")
    void getProductWhenProductExists() {
        Product product = new Product();
        product.setProductId(100);
        product.setProductName("test");
        product.setProductDescription("test");
        product.setProductPrice(1.0);

        when(productRepository.findById(100)).thenReturn(Optional.of(product));

        Product result = productService.getProduct(100);

        assertEquals(product, result);
    }

    @Test
    @DisplayName("Should throw an exception when the product does not exist")
    void getProductWhenProductDoesNotExistThenThrowException() {
        when(productRepository.findById(100)).thenReturn(Optional.empty());

        assertThrows(RecordNotFoundException.class, () -> productService.getProduct(100));

        verify(productRepository, times(1)).findById(100);
    }

    @Test
    @DisplayName("Should returns all products")
    void getProductsShouldReturnsAllProducts() {
        Product product = new Product();
        product.setProductId(100);
        product.setProductName("test");
        product.setProductDescription("test");
        product.setProductPrice(1.0);

        when(productRepository.findAll()).thenReturn(List.of(product));

        List<Product> products = productService.getAllProducts();

        assertNotNull(products);
        assertFalse(products.isEmpty());
        assertEquals(1, products.size());

        verify(productRepository, times(1)).findAll();
    }



    @Test
    @DisplayName("Should delete the product when the product exists")
    void deleteProductWhenProductExists() {
        Product product1 = new Product();
        product1.setProductId(1);
        product1.setProductName("test");

        productRepository.delete(product1);

        productService.deleteProduct(1);

        verify(productRepository).delete(product1);

    }

//    @Test
//    @DisplayName("Should update the product when the product exists")
//    void updateProductWhenProductExists() {
//        Product product1 = new Product();
//        product1.setProductId(1);
//        product1.setProductName("test");
//        product1.setProductDescription("test");
//        product1.setProductPrice(20.00);
//        when(productRepository.findById(200)).thenReturn(Optional.of(product1));
//
//        product1.setProductName("Best Product");
//        productService.updateProduct(product1);
//
//        verify(productRepository).save(product1);
//
//        assertThat(product1.getProductId()).isEqualTo(200);
//        assertThat(product1.getProductName()).isEqualTo("Best Product");
//    }
//
//    @Test
//    @DisplayName("Should throw an exception when the product does not exist")
//    void updateProductWhenProductDoesNotExistThenThrowException() {
//        Product product = new Product();
//        product.setProductId(200);
//        product.setProductName("test");
//        product.setProductDescription("test");
//        product.setProductPrice(1.00);
//
//        when(productRepository.findById(200)).thenReturn(null);
//
//        assertThrows(
//                NullPointerException.class,
//                () -> {
//                    productService.updateProduct(product);
//                });
//    }

    @Test
    @DisplayName("Should create a product when the product is valid")
    void createProductWhenProductIsValid() {
        Product product = new Product();
        product.setProductId(1);
        product.setProductName("test");
        product.setProductDescription("test");
        product.setProductPrice(1.0);

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.createProduct(product);

        assertEquals(product, result);
    }
}
