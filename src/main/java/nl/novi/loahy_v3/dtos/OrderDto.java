package nl.novi.loahy_v3.dtos;

import nl.novi.loahy_v3.models.Order;

import java.util.Map;

public class OrderDto {
    private Integer id;

    private Map<Integer, String> productList;

    private String comment;

    private CustomerDto customer;

    private String orderDate;


    public static OrderDto fromOrder(Order order) {

        var dto = new OrderDto();

        dto.setId(order.getId());

        dto.setProductList(order.getProductList());

        dto.setComment(order.getComment());

        dto.setCustomer(CustomerDto.transferToCustomerDto(order.getCustomer()));

        dto.setOrderDate(order.getOrderDate());

        return dto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<Integer, String> getProductList() {
        return productList;
    }

    public void setProductList(Map<Integer, String> productList) {
        this.productList = productList;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
