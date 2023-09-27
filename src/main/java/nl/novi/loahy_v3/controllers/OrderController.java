package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.OrderDto;
import nl.novi.loahy_v3.dtos.OrderInputDto;
import nl.novi.loahy_v3.models.Order;
import nl.novi.loahy_v3.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrders() {

        var dtos = new ArrayList<OrderDto>();

        var orders = orderService.getOrders();
        for (Order order : orders) {
            dtos.add(OrderDto.fromOrder(order));
        }
        return ResponseEntity.ok().body(dtos);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable("id") Long orderId){
        OrderDto optionalOrder = orderService.getOrder(orderId);
        return ResponseEntity.ok().body(optionalOrder);
    }


    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody @Valid OrderInputDto dto){
        return ResponseEntity.created(null).body(orderService.createOrder(dto));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable("id")Long orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }


}
