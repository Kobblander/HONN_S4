package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Review;

import java.util.List;

/**
 * <h1>DriverDataGateway</h1>
 * <h2>is.ru.honn.ruber.drivers.data</h2>
 * <p></p>
 * Created on 24.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public interface DriverDataGateway {
    public void addDriverReview(int driverId, Review review);
    public Driver getDriverById(int driverId);
    public List<Driver> getDrivers();
}
