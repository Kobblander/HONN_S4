package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Review;
import is.ruframework.data.RuDataAccess;

import java.util.List;

/**
 * <h1>DriverDataGateway</h1>
 * <h2>is.ru.honn.ruber.drivers.data</h2>
 * <p>This class handles the connection with the datasource.
 * This class adds rides to the database, it also handles getting a driver
 * by a particular ID and also returning a list of nearby drivers.</p>
 * Created on 24.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public interface DriverDataGateway extends RuDataAccess {
    /**
     * This function adds a review to the database, the review is
     * attached to a single driver.
     * @param driverId The id of the driver.
     * @param review The review itself, which contains a rating and comment.
     */
    public void addDriverReview(int driverId, Review review);

    /**
     * This function returns a single driver by its ID
     * @param driverId The id of the driver.
     * @return Returns a single driver.
     */
    public Driver getDriverById(int driverId);

    /**
     * This function returns a list of nearby drivers
     * @return Returns a list of nearby drivers.
     */
    public List<Driver> getDrivers();
}
