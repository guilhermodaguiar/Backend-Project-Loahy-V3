package nl.novi.loahy_v3.exceptions;

public class UserEmailAlreadyExistException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UserEmailAlreadyExistException(String userEmail) {

        super(String.format("User with email-adres'%s' already exists", userEmail));
    }
}
