package nl.novi.loahy_v3.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(nullable = false,
            unique = true)
    @Email(message = "user email not valid")
    @NotBlank(message = "email must not be blank")
    private String userEmail;

    @Column(nullable = false,
            unique = true)
    @NotBlank(message = "password must not be blank")
    private String password;

    @Column(nullable = false)
    private Long userId;

    @Column
    @NotBlank(message = "user first name must not be blank")
    private String firstName;

    @Column
    @NotBlank(message = "user last name must not be blank")
    private String lastName;

    @OneToOne
    Address address;

    @OneToOne
    Wishlist wishlist;


    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "userEmail",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Set<Authority> getAuthorities() {
        return authorities;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long id) {
        this.userId = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }
}

