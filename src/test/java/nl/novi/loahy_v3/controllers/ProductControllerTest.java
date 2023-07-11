package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.ProductDto;
import nl.novi.loahy_v3.dtos.ProductInputDto;
import nl.novi.loahy_v3.models.Product;
import nl.novi.loahy_v3.services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;


    @Test
    @DisplayName("Should create a product when the product is valid")
    void createProductWhenProductIsValid() {

        ProductInputDto productInputDto = new ProductInputDto();
        productInputDto.setProductName("test");
        productInputDto.setProductDescription("test");
        productInputDto.setProductPrice(100.00);

        Product product = new Product();
        product.setProductName("test");
        product.setProductDescription("test");
        product.setProductPrice(100.00);

        when(productService.createProduct(any())).thenReturn(product);

        ProductDto result = productController.createProduct(productInputDto);

        assertEquals(productInputDto.getProductName(), result.getProductName());
    }

    @Test
    @DisplayName("Should throw an exception when the product is invalid")
    void createProductWhenProductIsInvalidThenThrowException() {
        ProductInputDto productInputDto = new ProductInputDto();
        productInputDto.setProductName("");
        productInputDto.setProductDescription("");
        productInputDto.setProductPrice(0.00);

        assertThrows(
                NullPointerException.class,
                () -> productController.createProduct(productInputDto));
    }
}
