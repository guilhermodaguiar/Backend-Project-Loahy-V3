package nl.novi.loahy_v3.payload;
public class AuthenticationRequest {
    
    private String userEmail;
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