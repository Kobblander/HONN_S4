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
public class DriverNotFoundException extends Exception {

    public DriverNotFoundException() {
    }

    public DriverNotFoundException(String message) {
        super(message);
    }

    public DriverNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DriverNotFoundException(Throwable cause) {
        super(cause);
    }
}
