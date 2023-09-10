package nl.novi.loahy_v3.dtos;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class UserPasswordOnlyDto {

    public String userEmail;

    @NotBlank(message = "password must not be blank")
    public String password;

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
