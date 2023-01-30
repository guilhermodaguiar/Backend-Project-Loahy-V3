package nl.novi.loahy_v3.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.novi.loahy_v3.models.Authority;
import nl.novi.loahy_v3.models.Customer;
import nl.novi.loahy_v3.models.User;
import nl.novi.loahy_v3.models.Wishlist;


import java.util.Set;


public class UserDto {

    public String userEmail;
    public String password;

    @JsonSerialize
    public Customer customer;

    @JsonDeserialize
    public Wishlist wishlist;

    @JsonDeserialize
    public Set<Authority> authorities;

    public static UserDto fromUser(User user){

        var userDto = new UserDto();

        userDto.userEmail = user.getUserEmail();
        userDto.password = user.getUserPassword();
        userDto.authorities = user.getAuthorities();
        userDto.customer = (user.getCustomer());
        userDto.wishlist = (user.getWishlist());

        return userDto;
    }


    public String getUserPassword() {
        return password;
    }

    public void setUserPassword(String userPassword) {
        this.password = userPassword;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
