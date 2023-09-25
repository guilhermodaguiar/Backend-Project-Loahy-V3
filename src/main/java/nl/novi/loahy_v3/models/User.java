package nl.novi.loahy_v3.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String email;

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


    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "email",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }


    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }

    public void removeAuthority(Authority authority) {
        this.authorities.remove(authority);
    }

    public void setUserId(Long id) {
        this.userId = id;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }


    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
}

