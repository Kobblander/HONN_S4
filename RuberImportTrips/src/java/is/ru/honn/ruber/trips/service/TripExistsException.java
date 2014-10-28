package is.ru.honn.ruber.trips.service;

/**
 * <h1>TripExistsException</h1>
 * <h2>is.ru.honn.ruber.trips.service</h2>
 * <p>A simple exception which is thrown when duplicate trips are
 * detected.</p>
 * Created on 25.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class TripExistsException extends RuntimeException {

    /**
     * A constructor which only takes a message as a parameter
     * @param message The message of the error.
     */
    public TripExistsException(String message) {
        super(message);
    }

    /**
     * A constructor which both takes a message as a parameter and another
     * throwable cause.
     * @param message The message of the error.
     * @param cause Another throwable cause.
     */
    public TripExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
