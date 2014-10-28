package is.ru.honn.ruber.drivers.service;

/**
 * <h1>ProductNotFoundException</h1>
 * <h2>is.ru.honn.ruber.drivers.service</h2>
 * <p>A simple exception that gets thrown when a product is not found.</p>
 * Created on 26.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class ProductNotFoundException extends RuntimeException {

    /**
     * An empty constructor.
     */
    public ProductNotFoundException() {
    }

    /**
     * A constructor which only takes a message as a parameter
     * @param message The message of the error.
     */
    public ProductNotFoundException(String message) {
        super(message);
    }

    /**
     * A constructor which both takes a message as a parameter and another
     * throwable cause.
     * @param message The message of the error.
     * @param cause Another throwable cause.
     */
    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
