package nl.loahy_v3.service;

import nl.loahy_v3.exceptions.RecordNotFoundException;
import nl.loahy_v3.model.Product;
import nl.loahy_v3.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

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
        product.setProductId(1L);
        product.setProductName("test");
        product.setProductDescription("test");
        product.setProductPrice(1.0);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Product result = productService.getProduct(1L);

        assertEquals(product, result);
    }

    @Test
    @DisplayName("Should throw an exception when the product does not exist")
    void getProductWhenProductDoesNotExistThenThrowException() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RecordNotFoundException.class, () -> productService.getProduct(1L));

        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Should returns all products")
    void getProductsShouldReturnsAllProducts() {
        Product product = new Product();
        product.setProductId(1L);
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
        product1.setProductId(1L);
        product1.setProductName("test");

        productRepository.delete(product1);

        productService.deleteProduct(1L);

        verify(productRepository).delete(product1);

    }

    @Test
    @DisplayName("Should throw an exception when the product does not exist")
    void updateProductWhenProductDoesNotExistThenThrowException() {

        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RecordNotFoundException.class, () -> productService.getProduct(1L));

        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Should create a product when the product is valid")
    void createProductWhenProductIsValid() {
        Product product = new Product();
        product.setProductId(1L);
        product.setProductName("test");
        product.setProductDescription("test");
        product.setProductPrice(1.0);

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.createProduct(product);

        assertEquals(product, result);
    }
}
