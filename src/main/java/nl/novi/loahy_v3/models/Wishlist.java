package nl.novi.loahy_v3.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "wishlists" )
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="wishlistId")
public class Wishlist {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "wishlist_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "204"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(unique = true)
    private Integer wishlistId;

    @OneToOne
    User user;

   @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL, CascadeType.REMOVE})
   @JoinTable(name = "wishlist_product_table",
           joinColumns = {
                   @JoinColumn(name = "wishlist_id", referencedColumnName = "wishlistId")
           },
           inverseJoinColumns = {
                   @JoinColumn(name = "product_id", referencedColumnName = "productId")
           }

   )
   private Set<Product> products;
}