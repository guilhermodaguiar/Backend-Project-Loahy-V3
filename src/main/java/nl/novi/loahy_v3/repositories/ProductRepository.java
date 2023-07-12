package nl.novi.loahy_v3.repositories;

import nl.novi.loahy_v3.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
