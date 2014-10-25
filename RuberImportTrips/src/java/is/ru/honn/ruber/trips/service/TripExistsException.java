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
public class TripExistsException extends Exception {

    public TripExistsException() {
    }

    public TripExistsException(String message) {
        super(message);
    }

    public TripExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TripExistsException(Throwable cause) {
        super(cause);
    }
}
