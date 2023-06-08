//package nl.novi.loahy_v3.controllers;
//
//import nl.novi.loahy_v3.dtos.OrderDto;
//import nl.novi.loahy_v3.services.OrderService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//class OrderControllerTest {
//
//    @Mock
//    private OrderService orderService;
//
//    @InjectMocks
//    private OrderController orderController;
//
//    @Test
//    @DisplayName("Should throw an exception when the order is invalid ")
//    void createOrderWhenOrderIsInvalidThenThrowException() {
//        OrderDto orderDto = new OrderDto();
//        orderDto.setOrderDate("");
//    }
//}
