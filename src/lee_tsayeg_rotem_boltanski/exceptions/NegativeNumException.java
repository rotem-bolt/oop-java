package lee_tsayeg_rotem_boltanski.exceptions;

public class NegativeNumException extends Exception {
    private static final String PRE_ERROR = "The number ypu entered is lower than 0.";

    public NegativeNumException(String message) {
        super(PRE_ERROR + message);
    }
}
