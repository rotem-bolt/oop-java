package lee_tsayeg_rotem_boltanski.exceptions;

public class InvalidFieldValueException extends Exception {
    private static final String PRE_ERROR = "The number you entered is lower than 0.";

    public InvalidFieldValueException(String message) {
        super(PRE_ERROR + message);
    }
}
