package nl.novi.loahy_v3.models;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(nullable = false,
            unique = true)
    @NotBlank(message = "email must not be blank")
    @Email
    private String userEmail;

    @Column(nullable = false,
            unique = true)
    @NotBlank(message = "password must not be blank")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,15}$", message = "wachtwoord moet tussen 8 tot 15 tekens bevatten, 1 Hoofdletter en speciaal teken")
    private String password;

    @Column(nullable = false)
    private Long userId;

    @Column
    @NotBlank(message = "firstname must not be blank")
    private String firstName;

    @Column
    @NotBlank(message = "lastname must not be blank")
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


    public String setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return userEmail;
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
}

