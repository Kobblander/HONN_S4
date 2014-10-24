package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Review;
import is.ru.honn.ruber.drivers.data.DriverDataGateway;

import java.util.List;
import java.util.logging.Logger;

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

    private Logger log = Logger.getLogger(DriverServiceData.class.getName());
    private DriverDataGateway driverDataGateway;

    public DriverServiceData() {
    }

    public DriverServiceData(DriverDataGateway driverDataGateway) {
        this.driverDataGateway = driverDataGateway;
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
