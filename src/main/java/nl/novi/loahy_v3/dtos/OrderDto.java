package nl.novi.loahy_v3.dtos;

import nl.novi.loahy_v3.models.Order;
import nl.novi.loahy_v3.models.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OrderDto {
    private Long orderId;

    private List<Object> productList;

    private String comment;

    private String orderDate;

    private String userEmail;

    private Long addressId;


    public static OrderDto fromOrder(Order order) {

        var dto = new OrderDto();

        dto.setOrderId(order.getOrderId());

        dto.setProductList(Collections.singletonList(order.getProductList()));

        dto.setComment(order.getComment());

        dto.setOrderDate(order.getOrderDate());

        dto.setUserEmail(order.getUserEmail());

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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
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
