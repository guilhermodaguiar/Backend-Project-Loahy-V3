package nl.loahy_v3.exceptions;

import java.io.Serial;

public class NoEntityIdFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public NoEntityIdFoundException(String message) {
        super(message);
    }
}
