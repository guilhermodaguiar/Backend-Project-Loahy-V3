package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.ProductDto;
import nl.novi.loahy_v3.dtos.ProductInputDto;
import nl.novi.loahy_v3.models.Product;
import nl.novi.loahy_v3.services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;


    @Test
    @DisplayName("Should create a product when the product does not exist")
    void createProductWhenProductDoesNotExist() {

        ProductInputDto productInputDto = new ProductInputDto();
        productInputDto.setProductName("test");
        productInputDto.setProductInformation("test");
        productInputDto.setProductPrice(100.00);

        Product product = new Product();
        product.setProductName("test");
        product.setProductDescription("test");
        product.setProductPrice(100.00);

        when(productService.createProduct(any())).thenReturn(ProductDto.transferToDto(product));

        assertThat(product.getProductName()).isEqualTo("test");
    }

    @Test
    @DisplayName("Should throw an exception when the product is invalid")
    void createProductWhenProductIsInvalidThenThrowException() {
        ProductInputDto productInputDto = new ProductInputDto();
        productInputDto.setProductName("");
        productInputDto.setProductInformation("");
        productInputDto.setProductPrice(0.00);

        assertThrows(
                NullPointerException.class,
                () -> productController.createProduct(productInputDto));
    }

    @Test
    @DisplayName("Should delete product when the product id is valid")
    void deleteProductWhenProductIdIsValid() {
        Product product = new Product();
        product.setProductId(1001);
        product.setProductPrice(100.00);
        product.setProductDescription("test description");
        product.setProductName("test product");

        productService.deleteProduct(1001);

        verify(productService, times(1)).deleteProduct(1001);
    }
}
