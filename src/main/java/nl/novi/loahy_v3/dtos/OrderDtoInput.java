package nl.novi.loahy_v3.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;


public class OrderDtoInput {

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Integer> productList;
    private String comment;

    private Long customer;


    private String orderDate;


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
}
