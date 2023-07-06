package nl.novi.loahy_v3.repositories;


import nl.novi.loahy_v3.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
