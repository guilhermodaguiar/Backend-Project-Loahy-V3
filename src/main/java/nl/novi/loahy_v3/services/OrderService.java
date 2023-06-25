package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.OrderInputDto;
import nl.novi.loahy_v3.models.Order;
import nl.novi.loahy_v3.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin
public class OrderService {


    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> getOrders() {
        return orderRepository.findAll();
    }


    public Order createOrder(OrderInputDto orderInputDto) {
        Order order = new Order();

        order.setProductList(orderInputDto.getProductList());
        order.setComment(orderInputDto.getComment());
        order.setOrderDate(orderInputDto.getOrderDate());
        order.setUserEmail(orderInputDto.getUserEmail());
        order.setAddressId(orderInputDto.getAddressId());

        return orderRepository.save(order);
    }


    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

}
