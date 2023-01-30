package nl.novi.loahy_v3.repositories;

import nl.novi.loahy_v3.models.WishlistProduct;
import nl.novi.loahy_v3.models.WishlistProductKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface WishlistProductRepository extends JpaRepository<WishlistProduct, WishlistProductKey> {
    Collection<WishlistProduct> findAllByWishlist_WishlistId(Integer wishlistId);
    Collection<WishlistProduct> findAllByProduct_ProductId(Integer productId);
}
