package nl.novi.loahy_v3.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;


public class OrderInputDto {

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Integer> productList;
    private String comment;

    private Long customer;

    private String orderDate;

    public String streetName;
    public String houseNumber;
    public String city;
    public String houseNumberAddition;
    public String zipcode;
    public Long phone;


    public List<Integer> getProductList() {
        return productList;
    }

    public String getComment() {
        return comment;
    }

    public Long getCustomer() {
        return customer;
    }

    public void setProductList(List<Integer> productList) {
        this.productList = productList;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
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
