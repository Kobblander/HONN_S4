package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.domain.Review;
import is.ru.honn.ruber.drivers.service.DriverNotFoundException;
import is.ru.honn.ruber.drivers.service.ProductNotFoundException;
import is.ru.honn.ruber.drivers.service.ReviewExistsException;
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
     * @param review The review itself, which contains a rating and comment.
     */
    public void addDriverReview(Review review) throws ReviewExistsException;

    /**
     * This function returns a single driver by its ID
     * @param driverId The id of the driver.
     * @return Returns a single driver.
     */
    public Driver getDriverById(int driverId) throws DriverNotFoundException;

    /**
     * This function returns a list of reviews given a drivers
     * unique id.
     * @param driverId The id of the driver.
     * @return Returns a list of reviews.
     */
    public List<Review> getReviewsByDriverId(int driverId) throws DriverNotFoundException;

    /**
     * This function returns a list of nearby drivers
     * @return Returns a list of nearby drivers.
     */
    public List<Driver> getDrivers() throws DriverNotFoundException;

    /**
     * This function returns a given drivers product.
     * @param driverId The id of the driver.
     * @return Returns the product of the driver.
     */
    public Product getProductByDriverId(int driverId) throws ProductNotFoundException;
}
