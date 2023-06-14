package nl.novi.loahy_v3.repositories;


import nl.novi.loahy_v3.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
}

