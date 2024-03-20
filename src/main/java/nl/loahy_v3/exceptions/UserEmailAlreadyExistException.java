package nl.loahy_v3.exceptions;

import java.io.Serial;

public class UserEmailAlreadyExistException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public UserEmailAlreadyExistException(String email) {

        super(String.format("User with email-adres'%s' already exists", email));
    }
}
