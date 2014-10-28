package is.ru.honn.ruber.users.service;

/**
 * <h1>TripNotFoundException</h1>
 * <h2>is.ru.honn.ruber.users.service</h2>
 * <p>A simple exception which is thrown when a trip is not found.</p>
 * Created on 25.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class TripNotFoundException extends RuntimeException {

    /**
     * A constructor which only takes a message as a parameter
     * @param message The message of the error.
     */
    public TripNotFoundException(String message) {
        super(message);
    }

    /**
     * A constructor which both takes a message as a parameter and another
     * throwable cause.
     * @param message The message of the error.
     * @param cause Another throwable cause.
     */
    public TripNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
