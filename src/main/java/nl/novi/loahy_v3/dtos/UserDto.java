package nl.novi.loahy_v3.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import nl.novi.loahy_v3.models.Address;
import nl.novi.loahy_v3.models.Authority;
import nl.novi.loahy_v3.models.User;
import nl.novi.loahy_v3.models.Wishlist;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;


@Getter
public class UserDto {

    @NotBlank(message = "email must not be blank")
    @Email
    public String email;


    @NotBlank(message = "password must not be blank")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,15}$",
            message = "wachtwoord moet tussen 8 tot 15 tekens bevatten, 1 Hoofdletter, 1 cijfer en speciaal teken")
    public String password;

    @NotBlank(message = "firstname must not be blank")
    public String firstName;

    @NotBlank(message = "lastname must not be blank")
    public String lastName;

    public String apikey;

    public Long userId;

    @JsonDeserialize
    public Address address;

    @JsonDeserialize
    public Wishlist wishlist;

    @JsonDeserialize
    public Set<Authority> authorities;

    public static UserDto fromUser(User user) {

        var userDto = new UserDto();

        userDto.email = user.getEmail();
        userDto.firstName = user.getFirstName();
        userDto.lastName = user.getLastName();
        userDto.authorities = user.getAuthorities();
        userDto.address = (user.getAddress());
        userDto.wishlist = (user.getWishlist());

        return userDto;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public void setUserEmail(String email) {
        this.email = email;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }


    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    @JsonIgnore
    @JsonProperty(value = "password")
    public String getPassword() {
        return password;
    }
}