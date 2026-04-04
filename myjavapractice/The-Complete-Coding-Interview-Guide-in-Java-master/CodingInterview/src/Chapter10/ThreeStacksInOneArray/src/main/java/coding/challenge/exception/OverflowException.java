package Chapter10.ThreeStacksInOneArray.src.main.java.coding.challenge.exception;

public class OverflowException extends Exception {

    private static final long serialVersionUID = 7718828512143293558L;

    public OverflowException(String message) {
        super(message);
    }

    public OverflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
