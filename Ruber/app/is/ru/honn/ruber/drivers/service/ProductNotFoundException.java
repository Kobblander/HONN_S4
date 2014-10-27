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

    public ProductNotFoundException() {
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }
}
