package nl.novi.loahy_v3.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class WishlistProductKey implements Serializable {

    @Column(name = "wishlist_id")
    private Integer wishlistId;

    @Column(name = "product_id")
    private Integer productId;

    public WishlistProductKey() {
    }
    public WishlistProductKey(Integer wishlistId, Integer productId) {
        this.wishlistId = wishlistId;
        this.productId = productId;
    }

    public Integer getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Integer wishlistId) {
        this.wishlistId = wishlistId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        WishlistProductKey that = (WishlistProductKey) obj;
        return wishlistId.equals(that.wishlistId)&& productId.equals(that.productId);
    }

    @Override
    public int hashCode() {return Objects.hash(wishlistId, productId);}
}
