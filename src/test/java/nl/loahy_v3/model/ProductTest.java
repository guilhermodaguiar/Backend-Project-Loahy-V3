package nl.loahy_v3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    @DisplayName("Should set the product id")
    void setProductId() {
        Product product = new Product();
        product.setProductId(100);
        assertEquals(100, product.getProductId());
    }

    @Test
    @DisplayName("Should set the product name")
    void setName() {
        Product product = new Product();
        product.setProductName("Test Name");
        assertEquals("Test Name", product.getProductName());
    }

    @Test
    @DisplayName("Should set the description")
    void setDescription() {
        Product product = new Product();
        product.setProductDescription("description");
        assertEquals("description", product.getProductDescription());
    }

    @Test
    @DisplayName("Should set the price of the product")
    void setProductType() {
        Product product = new Product();
        product.setProductPrice(100.00);
        assertEquals(100.00, product.getProductPrice());
    }


    @Test
    @DisplayName("Should set the picture")
    void setImageShouldSetTheImage() {
        Product product = new Product();
        FileUploadResponse image = new FileUploadResponse("fileName", "contentType", "url");

        product.setImage(image);

        assertEquals(image, product.getImage());
    }

    @Test
    @DisplayName("Should return the image of the product")
    void getImageShouldReturnTheImageOfTheProduct() {
        Product product = new Product();
        FileUploadResponse image = new FileUploadResponse("fileName", "contentType", "url");
        product.setImage(image);

        assertEquals(image, product.getImage());
    }

    @Test
    @DisplayName("Should return the price of the product")
    void getPriceShouldReturnThePriceOfTheProduct() {
        Product product = new Product();
        product.setProductPrice(100.0);
        assertEquals(100.0, product.getProductPrice());
    }


    @Test
    @DisplayName("Should return the description of the product")
    void getDescriptionShouldReturnTheDescriptionOfTheProduct() {
        Product product = new Product();
        product.setProductDescription("This is a description");
        assertEquals("This is a description", product.getProductDescription());
    }

    @Test
    @DisplayName("Should return the product ")
    void getProductShouldReturnTheProduct() {
        Product product = new Product();
        product.setProductName("Test Name");
        assertEquals("Test Name", product.getProductName());
    }

    @Test
    @DisplayName("Should return the id of the product")
    void getIdShouldReturnTheIdOfTheProduct() {
        Product product = new Product();
        product.setProductId(100);
        assertEquals(100, product.getProductId());
    }

}
