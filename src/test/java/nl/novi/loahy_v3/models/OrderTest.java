package nl.novi.loahy_v3.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Order")
class OrderTest {


    @Test
    @DisplayName("Should set the product list")
    void setProductList() {
        Order order = new Order();
        Map<Integer, String> productList = Map.of(1, "test");
        order.setProductList(productList);
        assertEquals(productList, order.getProductList());
    }

    @Test
    @DisplayName("Should return the product list")
    void getProductListShouldReturnProductList() {
        Order order = new Order();
        order.setProductList(Map.of(1, "test"));

        assertEquals(Map.of(1, "test"), order.getProductList());
    }

    @Test
    @DisplayName("Should set the id")
    void setOrderId() {
        Order order = new Order();
        order.setId(1);
        assertEquals(1, order.getId());
    }

    @Test
    @DisplayName("Should return the id of the order")
    void getIdShouldReturnTheIdOfTheDeliveryRequest() {
        Order order = new Order();
        order.setId(1);

        assertEquals(1, order.getId());
    }
}
