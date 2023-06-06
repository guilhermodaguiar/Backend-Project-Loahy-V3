package nl.novi.loahy_v3.repositories;

import nl.novi.loahy_v3.models.Product;
import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.models.WishlistProduct;
import nl.novi.loahy_v3.models.WishlistProductKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface WishlistProductRepository extends JpaRepository<WishlistProduct, WishlistProductKey> {
    Collection<WishlistProduct> findAllByWishlist_WishlistId(Integer wishlistId);
    Collection<WishlistProduct> findAllByProduct_ProductId(Integer productId);

    Collection<WishlistProduct> findByProduct_ProductId(Integer productId);

    Collection<WishlistProduct> findByWishlist_WishlistId(Integer wishlistId);



    // even testen
    Collection<WishlistProduct> findById_ProductIdIn(Collection<Integer> WishlistId);

//    void deleteByIdIn(Collection<WishlistProduct> productId);
}
