package nl.novi.loahy_v3.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.novi.loahy_v3.models.FileUploadResponse;
import nl.novi.loahy_v3.models.Product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductInputDto {

    @NotBlank(message = "product name must not be blank")
    public String productName;

    @NotBlank(message = "product description must not be blank")
    public String productDescription;

    @NotNull(message = "product price must not be empty")
    public Double productPrice;

    @JsonSerialize
    FileUploadResponse image;

    public Product toProduct() {

        var product = new Product();

        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setProductPrice(productPrice);

        return product;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public FileUploadResponse getImage() {
        return image;
    }

    public void setImage(FileUploadResponse image) {
        this.image = image;
    }
}
