package nl.novi.loahy_v3.repositories;


import nl.novi.loahy_v3.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    boolean existsProductByProductId(Product productId);
}
