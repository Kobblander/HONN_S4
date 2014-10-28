package is.ru.honn.ruber.drivers.service;

import org.springframework.dao.DataIntegrityViolationException;

/**
 * <h1>ReviewExistsException</h1>
 * <h2>is.ru.honn.ruber.drivers.service</h2>
 * <p>A simple exception which is thrown when a review already exists in the database.</p>
 * Created on 26.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class ReviewExistsException extends RuntimeException {

    /**
     * A constructor which only takes a message as a parameter
     * @param message The message of the error.
     */
    public ReviewExistsException(String message) {
        super(message);
    }

    /**
     * A constructor which both takes a message as a parameter and another
     * throwable cause.
     * @param message The message of the error.
     * @param cause Another throwable cause.
     */
    public ReviewExistsException(String message, Throwable cause) {
        super(message, cause);
    }

}
