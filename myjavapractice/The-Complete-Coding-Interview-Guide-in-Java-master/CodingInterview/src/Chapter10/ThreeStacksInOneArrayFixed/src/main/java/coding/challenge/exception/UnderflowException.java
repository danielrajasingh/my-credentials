package Chapter10.ThreeStacksInOneArrayFixed.src.main.java.coding.challenge.exception;
 
public class UnderflowException extends Exception {

    private static final long serialVersionUID = 7718828512143293558L;

    public UnderflowException(String message) {
        super(message);
    }

    public UnderflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
