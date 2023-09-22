package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.OrderInputDto;
import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.models.Order;
import nl.novi.loahy_v3.repositories.OrderRepository;
import nl.novi.loahy_v3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;

@Service
@CrossOrigin
public class OrderService {


    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }


    public List<Order> getOrders() {
        return orderRepository.findAll();
    }


    public Order createOrder(OrderInputDto orderInputDto) {
        var order = new Order();

        order.setProductList(orderInputDto.getProductList());
        order.setComment(orderInputDto.getComment());
        order.setOrderDate(LocalDate.parse(orderInputDto.getOrderDate()));
        order.setAddressId(orderInputDto.getAddressId());
        order.setEmail(String.valueOf(userRepository.getReferenceById(orderInputDto.getEmail())));

        return orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new RecordNotFoundException("Order met id bestaat niet" );
        }
        orderRepository.deleteById(orderId);
    }

}
