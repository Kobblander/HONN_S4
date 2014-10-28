package is.ru.honn.ruber.drivers.service;

/**
 * <h1>DriverNotFoundException</h1>
 * <h2>is.ru.honn.ruber.drivers.service</h2>
 * <p>This is a basic exception which is thrown when a driver is not found.</p>
 * Created on 24.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class DriverNotFoundException extends RuntimeException {


    /**
     * An empty constructor.
     */
    public DriverNotFoundException() {
    }

    /**
     * A constructor which only takes a message as a parameter
     * @param message The message of the error.
     */
    public DriverNotFoundException(String message) {
        super(message);
    }

    /**
     * A constructor which both takes a message as a parameter and another
     * throwable cause.
     * @param message The message of the error.
     * @param cause Another throwable cause.
     */
    public DriverNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
