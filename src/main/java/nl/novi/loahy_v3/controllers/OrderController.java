package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.OrderDto;
import nl.novi.loahy_v3.dtos.OrderInputDto;
import nl.novi.loahy_v3.models.Order;
import nl.novi.loahy_v3.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping(value = "/all")
    public List<OrderDto> getDeliveryRequests() {

        var dtos = new ArrayList<OrderDto>();
        List<Order> orderList;

        var orders = orderService.getOrders();
        for (Order order : orders) {
            dtos.add(OrderDto.fromOrder(order));
        }
        return dtos;
    }




    @PostMapping(value = "/create")
    public Order createOrder(@RequestBody OrderInputDto dto){

        return orderService.createOrder(dto);
    }



    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id")Integer id){
        orderService.deleteOrder(id);

        return ResponseEntity.noContent().build();
    }


}
