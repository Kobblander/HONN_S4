package is.ru.honn.ruber.drivers.service;

/**
 * <h1>ReviewNotFoundException</h1>
 * <h2>is.ru.honn.ruber.drivers.service</h2>
 * <p>A simple exception which is thrown when a review is not found.</p>
 * Created on 27.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class ReviewNotFoundException extends RuntimeException {

    /**
     * A constructor which only takes a message as a parameter
     * @param message The message of the error.
     */
    public ReviewNotFoundException(String message) {
        super(message);
    }

    /**
     * A constructor which both takes a message as a parameter and another
     * throwable cause.
     * @param message The message of the error.
     * @param cause Another throwable cause.
     */
    public ReviewNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
