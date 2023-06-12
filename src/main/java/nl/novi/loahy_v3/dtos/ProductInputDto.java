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
}
