package is.ru.honn.ruber.drivers.service;

import org.springframework.dao.DataIntegrityViolationException;

/**
 * <h1>ReviewExistsException</h1>
 * <h2>is.ru.honn.ruber.drivers.service</h2>
 * <p></p>
 * Created on 26.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class ReviewExistsException extends RuntimeException {

    public ReviewExistsException() {
    }

    public ReviewExistsException(String message) {
        super(message);
    }

    public ReviewExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReviewExistsException(Throwable cause) {
        super(cause);
    }
}
