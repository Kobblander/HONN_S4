package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.domain.Review;

import java.util.List;

/**
 * <h1>DriverService</h1>
 * <h2>is.ru.honn.ruber.drivers.service</h2>
 * <p></p>
 * Created on 24.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public interface DriverService {
    public List<Driver> getDrivers();
    public List<Review> getDriverReviews(int driverId);
    public void addDriverReview(int driverId, Review review);
	public Driver getDriverByID(int driverID);
	public Product getProductByDriverId(int driverID);
}
