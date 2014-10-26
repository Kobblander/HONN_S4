package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.domain.Review;

import java.util.List;

/**
 * <h1>DriverService</h1>
 * <h2>is.ru.honn.ruber.drivers.service</h2>
 * <p>This class services various kinds of data pertaining to drivers.
 * You can ask for a list of all drivers, a list of reviews given a drivers
 * unique driver id or you can post a review about a driver.</p>
 * Created on 24.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public interface DriverService {
    /**
     * This function returns a list of all drivers.
     * @return The list of all drivers.
     */
    public List<Driver> getDrivers() throws DriverNotFoundException;

    /**
     * This function returns all reviews given a drivers id.
     * @param driverId The unique driver id.
     * @return The list of all reviews.
     */
    public List<Review> getDriverReviews(int driverId) throws DriverNotFoundException;

    /**
     * This function attaches a review to a single driver,
     * given the drivers unique driver id.
     * @param review The review to be added.
     */
    public void addDriverReview(Review review) throws ReviewExistsException;

    /**
     * This function returns a single driver given a unique driver id.
     * @param driverId The unique driver id.
     * @return Returns the Driver.
     */
	public Driver getDriverByID(int driverId) throws DriverNotFoundException;

    /**
     * This functions returns a product which belongs to a driver.
     * The product is essentially the product the driver is selling, his
     * car.
     * @param driverId The unique driver id.
     * @return Returns the drivers product.
     */
	public Product getProductByDriverId(int driverId) throws ProductNotFoundException;

    /**
     * This function returns an average rating of one driver.
     * @param driverId The unique driver id.
     * @return Returns an average rating.
     */
    public double getAverageRating(int driverId) throws DriverNotFoundException;
}
