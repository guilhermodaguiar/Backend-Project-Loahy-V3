package nl.loahy_v3.controller;

import nl.loahy_v3.dto.OrderDto;
import nl.loahy_v3.dto.OrderInputDto;
import nl.loahy_v3.model.Order;
import nl.loahy_v3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
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
