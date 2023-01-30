package nl.novi.loahy_v3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "wishlists" )
public class Wishlist {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "wishlist_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "202"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(nullable = false, unique = true)
    private Integer wishlistId;

    @Column
    private String wishlistName;


    @OneToMany(mappedBy = "wishlist")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    Collection<WishlistProduct> wishlistProducts;

    public Integer getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Integer wishlistId) {
        this.wishlistId = wishlistId;
    }


    public Collection<WishlistProduct> getWishlistProducts() {
        return wishlistProducts;
    }

    public void setWishlistProducts(Collection<WishlistProduct> wishlistProducts) {
        this.wishlistProducts = wishlistProducts;
    }


    public String getWishlistName() {
        return wishlistName;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }
}
