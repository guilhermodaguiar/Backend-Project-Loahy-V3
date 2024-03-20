package nl.loahy_v3.service;

import lombok.AllArgsConstructor;
import nl.loahy_v3.exceptions.RecordNotFoundException;
import nl.loahy_v3.repository.OrderRepository;
import nl.loahy_v3.repository.UserRepository;
import nl.loahy_v3.dto.OrderDto;
import nl.loahy_v3.dto.OrderInputDto;
import nl.loahy_v3.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

import static nl.loahy_v3.dto.OrderDto.fromOrder;

@Service
@CrossOrigin
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    //Moet nog testen
    public OrderDto getOrder(Long orderId) {
        OrderDto dto = new OrderDto();
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            dto = fromOrder(order.get());
        } else {
            throw new RecordNotFoundException("Order bestaat niet..");
        }
        return dto;
    }


    public Order createOrder(OrderInputDto orderInputDto) {
        var order = new Order();

        order.setProductList(orderInputDto.getProductList());
        order.setComment(orderInputDto.getComment());
        order.setOrderDate(orderInputDto.getOrderDate());
        order.setAddressId(orderInputDto.getAddressId());
        order.setEmail(userRepository.getReferenceById(orderInputDto.getEmail()));

        return orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new RecordNotFoundException("Order met id " + orderId + " bestaat niet");
        }
        orderRepository.deleteById(orderId);
    }

}
