package nl.novi.loahy_v3.dtos;

import nl.novi.loahy_v3.models.Order;

import java.util.Map;

public class OrderDto {
    private Integer id;

    private Map<Integer, String> productList;

    private String comment;

    private String orderDate;

    public String streetName;
    public String houseNumber;
    public String city;
    public String houseNumberAddition;
    public String zipcode;
    public Long phone;




    public static OrderDto fromOrder(Order order) {

        var dto = new OrderDto();

        dto.setId(order.getId());

        dto.setProductList(order.getProductList());

        dto.setComment(order.getComment());

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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNumberAddition() {
        return houseNumberAddition;
    }

    public void setHouseNumberAddition(String houseNumberAddition) {
        this.houseNumberAddition = houseNumberAddition;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
