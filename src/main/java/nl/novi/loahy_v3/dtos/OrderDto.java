package nl.novi.loahy_v3.dtos;

import lombok.Getter;
import lombok.Setter;
import nl.novi.loahy_v3.models.Order;

import java.util.List;

@Getter
@Setter
public class OrderDto {

    private Long orderId;

    private List<Object> productList;

    private String comment;

    private String orderDate;

    private UserDto email;

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
}
