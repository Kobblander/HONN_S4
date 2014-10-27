package is.ru.honn.ruber.drivers.service;

/**
 * <h1>ReviewNotFoundException</h1>
 * <h2>is.ru.honn.ruber.drivers.service</h2>
 * <p></p>
 * Created on 27.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class ReviewNotFoundException extends RuntimeException {

    public ReviewNotFoundException() {
    }

    public ReviewNotFoundException(String message) {
        super(message);
    }

    public ReviewNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReviewNotFoundException(Throwable cause) {
        super(cause);
    }
}
