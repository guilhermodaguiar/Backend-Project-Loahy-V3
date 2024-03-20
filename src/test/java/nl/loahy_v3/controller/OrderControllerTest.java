package nl.loahy_v3.controller;

import nl.loahy_v3.dto.OrderInputDto;
import nl.loahy_v3.repository.OrderRepository;
import nl.loahy_v3.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderControllerTest {

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;


    @Test
    @DisplayName("Should throw an exception when the order is invalid ")
    void createOrderWhenOrderIsInvalidThenThrowException() {
        OrderInputDto orderInputDto = new OrderInputDto();
        orderInputDto.setProductList(new ArrayList<>());
        orderInputDto.setComment("");
        orderInputDto.setOrderDate("");
        orderInputDto.setEmail("");

        assertThrows(
                NullPointerException.class,
                () -> orderController.createOrder(orderInputDto));
    }
}
