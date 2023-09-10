package nl.novi.loahy_v3.payload;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
public class AuthenticationRequest {

    @NotBlank(message = "user email must not be blank")
    @Email
    private String userEmail;
    @NotBlank(message = "password must not be blank")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,15}$",
            message = "wachtwoord moet tussen 8 tot 15 tekens bevatten, 1 Hoofdletter en speciaal teken")
    private String password;

    public AuthenticationRequest(){
    }

    public AuthenticationRequest(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}