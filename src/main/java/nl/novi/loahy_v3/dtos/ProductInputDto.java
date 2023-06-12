package nl.novi.loahy_v3.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.novi.loahy_v3.models.FileUploadResponse;
import nl.novi.loahy_v3.models.Product;
public class ProductInputDto {

    public String productName;

    public String productDescription;

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
