package nl.novi.loahy_v3.exceptions;

import java.io.Serial;

public class UserEmailNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserEmailNotFoundException(String username) {
        super("Cannot find user " + username);
    }

}
