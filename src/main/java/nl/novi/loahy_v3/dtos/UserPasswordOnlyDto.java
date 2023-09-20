package nl.novi.loahy_v3.dtos;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class UserPasswordOnlyDto {

    public String email;

    @NotBlank(message = "password must not be blank")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,15}$",
            message = "wachtwoord moet tussen 8 tot 15 tekens bevatten, 1 Hoofdletter, 1 cijfer en speciaal teken")
    public String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
