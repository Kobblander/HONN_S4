package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Review;

import java.util.List;

/**
 * <h1>DriverServiceData</h1>
 * <h2>is.ru.honn.ruber.drivers.service</h2>
 * <p></p>
 * Created on 24.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class DriverServiceData implements DriverService {

    public DriverServiceData() {
    }

    @Override
    public List<Driver> getDrivers() {
        return null;
    }

    @Override
    public Review getDriverReview(int driverId) {
        return null;
    }

    @Override
    public void addDriverReview(int driverId, Review review) {

    }
}
