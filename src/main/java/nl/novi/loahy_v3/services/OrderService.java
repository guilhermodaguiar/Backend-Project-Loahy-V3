package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.OrderDtoInput;
import nl.novi.loahy_v3.models.Order;
import nl.novi.loahy_v3.models.Product;
import nl.novi.loahy_v3.repositories.CustomerRepository;
import nl.novi.loahy_v3.repositories.OrderRepository;
import nl.novi.loahy_v3.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@CrossOrigin
public class OrderService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;


    public OrderService(CustomerRepository customerRepository,
                        OrderRepository orderRepository,
                        ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }


    public List<Order> getOrders() {
        return orderRepository.findAll();
    }



    public Order createOrder(OrderDtoInput orderDtoInput) {
        Order order = new Order();

        Map<Integer, String> productList2 = new HashMap<>();
        List<Integer> productListLong = orderDtoInput.getProductList();

        for (Integer productId : productListLong) {
            Optional<Product> optional = productRepository.findById(productId);

            if (!productList2.containsKey(productId)) {
                productList2.put(productId, "1-" + "x " + optional.get().getProductName() + "-" + '_' + '€' + optional.get().getProductPrice());
            } else {
                String[] customArr = productList2.get(productId).split("-");

                int quantity = Integer.parseInt(customArr[0]);
                int actualQuantity = quantity + 1;

                double doubleValue = optional.get().getProductPrice() * actualQuantity;
                BigDecimal bigDecimalDouble = new BigDecimal(doubleValue);

                BigDecimal bigDecimalWithScale = bigDecimalDouble.setScale(2, RoundingMode.HALF_UP);

                productList2.put(productId, actualQuantity + "-x " + optional.get().getProductName() + "-" + '_' + '€' + bigDecimalWithScale);

            }
        }
        order.setProductList(productList2);
        order.setComment(orderDtoInput.getComment());
        order.setCustomer(customerRepository.getReferenceById(orderDtoInput.getCustomer()));
        order.setOrderDate(orderDtoInput.getOrderDate());

        return orderRepository.save(order);
    }


    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }


}
