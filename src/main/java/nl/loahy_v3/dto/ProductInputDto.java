package nl.loahy_v3.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import nl.loahy_v3.model.FileUploadResponse;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class ProductInputDto {

    public Long productId;

    @NotBlank(message = "product name must not be blank")
    public String productName;

    @NotBlank(message = "product description must not be blank")
    public String productDescription;

    @NotNull(message = "product price must not be empty")
    public Double productPrice;

    @JsonSerialize
    FileUploadResponse image;
}
