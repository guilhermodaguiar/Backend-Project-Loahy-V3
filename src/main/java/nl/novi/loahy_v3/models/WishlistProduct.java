package nl.novi.loahy_v3.models;

import javax.persistence.*;

@Entity
public class WishlistProduct {

    @EmbeddedId
    private WishlistProductKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("wishlistId")
    @JoinColumn(name = "wishlist_id")
    private Wishlist wishlist;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    public WishlistProductKey getId() {
        return id;
    }

    public void setId(WishlistProductKey id) {
        this.id = id;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
