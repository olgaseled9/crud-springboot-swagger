package by.seledtsovaos.swagger.exeption;

/**
 * Thrown if it is not possible to do crud operations.
 */
public class ServiceException extends RuntimeException {

    /**
     * Constructs a new exception with the specified detail message.
     * @param message describing an exception
     * @param cause error's cause
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
