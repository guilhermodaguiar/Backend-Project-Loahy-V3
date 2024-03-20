package nl.loahy_v3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Order")
class OrderTest {

    @Test
    @DisplayName("Should set the product list")
    void setProductList() {
        Order order = new Order();
        List<Object> productList = List.of(1L, "test");
        order.setProductList(productList);
        assertEquals(productList, order.getProductList());
    }

    @Test
    @DisplayName("Should return the product list")
    void getProductListShouldReturnProductList() {
        Order order = new Order();
        order.setProductList(List.of(1, "test"));

        assertEquals(List.of(1, "test"), order.getProductList());
    }

    @Test
    @DisplayName("Should set the id")
    void setOrderId() {
        Order order = new Order();
        order.setOrderId(1L);
        assertEquals(1, order.getOrderId());
    }

    @Test
    @DisplayName("Should return the id of the order")
    void getIdShouldReturnTheIdOfTheDeliveryRequest() {
        Order order = new Order();
        order.setOrderId(1L);

        assertEquals(1, order.getOrderId());
    }
}
