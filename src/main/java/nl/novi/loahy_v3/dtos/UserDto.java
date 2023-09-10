package nl.novi.loahy_v3.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import nl.novi.loahy_v3.models.Address;
import nl.novi.loahy_v3.models.Authority;
import nl.novi.loahy_v3.models.User;
import nl.novi.loahy_v3.models.Wishlist;

import java.util.Set;


@Getter
public class UserDto {
    public String userEmail;

    public String firstName;

    public String lastName;

    @JsonDeserialize
    public Address address;

    @JsonDeserialize
    public Wishlist wishlist;

    @JsonDeserialize
    public Set<Authority> authorities;

    public static UserDto fromUser(User user) {

        var userDto = new UserDto();

        userDto.userEmail = user.getUserEmail();
        userDto.firstName = user.getFirstName();
        userDto.lastName = user.getLastName();
        userDto.authorities = user.getAuthorities();
        userDto.address = (user.getAddress());
        userDto.wishlist = (user.getWishlist());

        return userDto;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }
}