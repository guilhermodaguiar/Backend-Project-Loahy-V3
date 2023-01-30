package nl.novi.loahy_v3.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.novi.loahy_v3.models.FileUploadResponse;
import nl.novi.loahy_v3.models.Product;

public class ProductDto {

    public Integer productId;

    public String productName;

    public String productInformation;

    public Double productPrice;

    @JsonSerialize
    FileUploadResponse image;

    public static ProductDto transferToDto(Product product) {

        var productDto = new ProductDto();

        productDto.productId = product.getProductId();
        productDto.productInformation = product.getProductDescription();
        productDto.productName = product.getProductName();
        productDto.productPrice = product.getProductPrice();
        productDto.image = (product.getImage());

        return productDto;
    }


    public FileUploadResponse getImage() {
        return image;
    }

    public void setImage(FileUploadResponse image) {
        this.image = image;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation;
    }


    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}
