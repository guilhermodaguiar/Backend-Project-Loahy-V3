package nl.novi.loahy_v3.payload;

import javax.validation.constraints.NotBlank;

public class AuthenticationRequest {

    @NotBlank(message = "user email must not be blank")
    private String userEmail;
    @NotBlank(message = "password must not be blank")
    private String password;

    public AuthenticationRequest(){
    }

    public AuthenticationRequest(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}