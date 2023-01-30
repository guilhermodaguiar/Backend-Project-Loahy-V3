package nl.novi.loahy_v3.repositories;


import nl.novi.loahy_v3.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    Optional<Wishlist> findByWishlistId(Integer wishlistId);
}
