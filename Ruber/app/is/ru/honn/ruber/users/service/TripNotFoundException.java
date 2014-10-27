package is.ru.honn.ruber.users.service;

/**
 * <h1>TripNotFoundException</h1>
 * <h2>is.ru.honn.ruber.trips.service</h2>
 * <p></p>
 * Created on 25.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class TripNotFoundException extends RuntimeException {

    public TripNotFoundException() {
    }

    public TripNotFoundException(String message) {
        super(message);
    }

    public TripNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TripNotFoundException(Throwable cause) {
        super(cause);
    }
}
