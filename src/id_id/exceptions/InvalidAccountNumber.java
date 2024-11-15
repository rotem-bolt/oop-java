package id_id.exceptions;

public class InvalidAccountNumber extends Exception {
    private static final String PRE_ERROR = "The Choice you entered is not valid.";

    public InvalidAccountNumber(String message) {
        super(PRE_ERROR + message);
    }
}
