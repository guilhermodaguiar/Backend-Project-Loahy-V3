package nl.novi.loahy_v3.dtos;

import lombok.Getter;
import lombok.Setter;
import nl.novi.loahy_v3.models.Order;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
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
        dto.setOrderDate(String.valueOf(order.getOrderDate()));
        dto.setEmail(UserDto.fromUser(order.getEmail()));
        dto.setAddressId(order.getAddressId());

        return dto;
    }
}
