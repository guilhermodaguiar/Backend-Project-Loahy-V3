package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.OrderInputDto;
import nl.novi.loahy_v3.models.Order;
import nl.novi.loahy_v3.repositories.OrderRepository;
import nl.novi.loahy_v3.services.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
