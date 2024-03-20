package nl.loahy_v3.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import nl.loahy_v3.model.Address;
import nl.loahy_v3.model.Authority;
import nl.loahy_v3.model.User;
import nl.loahy_v3.model.Wishlist;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;


@Getter
@Setter
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

    @JsonIgnore
    @JsonProperty(value = "password")
    public String getPassword() {
        return password;
    }
}