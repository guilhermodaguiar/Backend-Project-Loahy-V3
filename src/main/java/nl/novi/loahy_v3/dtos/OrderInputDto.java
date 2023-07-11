package nl.novi.loahy_v3.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class OrderInputDto implements Serializable {


    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @NotEmpty(message = "product list must not be empty")
    private List<Object> productList;
    private String comment;

    @NotEmpty(message = "order date must not be empty")
    private String orderDate;

    @NotEmpty(message = "user email must not be empty")
    @Email(message = "invalid email address")
    private String userEmail;

    @NotNull(message = "address must not be null")
    private Long addressId;



    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getComment() {
        return comment;
    }

    public List<Object> getProductList() {
        return productList;
    }

    public void setProductList(List<Object> productList) {
        this.productList = productList;
    }

    public Long getAddressId() {
        return addressId;
    }

}
