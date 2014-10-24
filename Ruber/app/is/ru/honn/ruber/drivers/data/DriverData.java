package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Review;
import is.ruframework.data.RuData;

import java.util.List;

/**
 * <h1>DriverData</h1>
 * <h2>is.ru.honn.ruber.drivers.data</h2>
 * <p>This class implements the DriverDataGateway and thusly handles the connection
 * to the database. This class also extends RuData which supplies the DataSource. The
 * DriverService config file supplies the datasource.</p>
 * Created on 24.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class DriverData extends RuData implements DriverDataGateway {

    @Override
    public void addDriverReview(int driverId, Review review) {

    }

    @Override
    public Driver getDriverById(int driverId) {
        return null;
    }

    @Override
    public List<Driver> getDrivers() {
        return null;
    }
}
