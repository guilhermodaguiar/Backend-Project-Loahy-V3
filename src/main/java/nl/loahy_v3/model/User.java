package nl.loahy_v3.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Setter
    @Id
    @Column(nullable = false, unique = true)
    private String email;

    @Setter
    @Column(nullable = false,
            unique = true)
    private String password;

    public String apikey;

    @Column(nullable = false)
    private Long userId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToOne
    Address address;

    @OneToOne
    Wishlist wishlist;

    @OneToMany(mappedBy = "email")
    private List<Order> order;


    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "email",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();

    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }

    public void removeAuthority(Authority authority) {
        this.authorities.remove(authority);
    }
}