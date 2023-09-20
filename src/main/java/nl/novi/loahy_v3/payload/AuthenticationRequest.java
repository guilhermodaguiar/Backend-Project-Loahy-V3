package nl.novi.loahy_v3.payload;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class AuthenticationRequest {

    @NotBlank(message = "user email must not be blank")
    private String email;
    @NotBlank(message = "password must not be blank")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,15}$",
            message = "wachtwoord moet tussen 8 tot 15 tekens bevatten, 1 Hoofdletter, 1 cijfer en speciaal teken")
    private String password;

    public AuthenticationRequest(){
    }

    public AuthenticationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}