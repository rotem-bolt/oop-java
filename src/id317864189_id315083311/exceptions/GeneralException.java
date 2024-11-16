package id317864189_id315083311.exceptions;

public class GeneralException extends Exception {
    private static final String PRE_ERROR = "Error: ";

    public GeneralException(String message) {
        super(PRE_ERROR + message);
    }
}
