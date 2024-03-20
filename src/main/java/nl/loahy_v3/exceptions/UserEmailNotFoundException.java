package nl.loahy_v3.exceptions;

public class UserEmailNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UserEmailNotFoundException(String email) {
        super("Cannot find user " + email);
    }

}
