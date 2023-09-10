package nl.novi.loahy_v3.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import nl.novi.loahy_v3.models.FileUploadResponse;
import nl.novi.loahy_v3.models.Product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class ProductDto {

    public Integer productId;

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

    public static ProductDto transferToDto(Product product) {

        var productDto = new ProductDto();

        productDto.productId = product.getProductId();
        productDto.productName = product.getProductName();
        productDto.productDescription = product.getProductDescription();
        productDto.productPrice = product.getProductPrice();
        productDto.image = (product.getImage());

        return productDto;
    }

}
