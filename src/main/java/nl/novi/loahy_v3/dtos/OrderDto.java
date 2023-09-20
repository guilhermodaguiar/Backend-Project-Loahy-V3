package nl.novi.loahy_v3.dtos;

import lombok.Getter;
import nl.novi.loahy_v3.models.Order;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
public class OrderDto {
    private Long orderId;

    @NotNull
    private List<Object> productList;

    private String comment;
    @NotNull
    private String orderDate;

    private UserDto email;

    @NotNull
    private Long addressId;


    public static OrderDto fromOrder(Order order) {

        var dto = new OrderDto();

        dto.setOrderId(order.getOrderId());
        dto.setProductList(order.getProductList());
        dto.setComment(order.getComment());
        dto.setOrderDate(order.getOrderDate());
        dto.setEmail(UserDto.fromUser(order.getEmail()));
        dto.setAddressId(order.getAddressId());

        return dto;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setEmail(UserDto email) {
        this.email = email;
    }

    public void setProductList(List<Object> productList) {
        this.productList = productList;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
