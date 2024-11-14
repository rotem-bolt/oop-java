package id_id.exceptions;

public class DuplicationException extends Exception {
    public DuplicationException(String message) {
        super(message);
    }

    public DuplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
