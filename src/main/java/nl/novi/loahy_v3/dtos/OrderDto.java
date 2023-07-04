package nl.novi.loahy_v3.dtos;

import nl.novi.loahy_v3.models.Order;


import java.util.List;

public class OrderDto{
    private Long orderId;

    private List<Object> productList;

    private String comment;

    private String orderDate;

    private UserDto userEmail;

    private Long addressId;


    public static OrderDto fromOrder(Order order) {

        var dto = new OrderDto();

        dto.setOrderId(order.getOrderId());

        dto.setProductList(order.getProductList());

        dto.setComment(order.getComment());

        dto.setOrderDate(order.getOrderDate());

        dto.setUserEmail(UserDto.fromUser(order.getUserEmail()));

        dto.setAddressId(order.getAddressId());

        return dto;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public UserDto getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(UserDto userEmail) {
        this.userEmail = userEmail;
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

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
