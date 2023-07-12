package nl.novi.loahy_v3.dtos;

import javax.validation.constraints.NotBlank;

public class UserPasswordOnlyDto {

    public String userEmail;

    @NotBlank(message = "password must not be blank")
    public String password;

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
}
