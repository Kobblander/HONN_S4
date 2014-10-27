package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.domain.Review;
import is.ru.honn.ruber.drivers.data.DriverDataGateway;

import java.util.List;
import java.util.logging.Logger;

/**
 * <h1>DriverServiceData</h1>
 * <h2>is.ru.honn.ruber.drivers.service</h2>
 * <p>This class implements the DriverService and is the link between the controllers
 * and the database. This function uses the DriverDataGateway to add data
 * to the database.</p>
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
        return driverDataGateway.getDrivers();
    }

    @Override
    public List<Review> getDriverReviews(int driverId) {
        return driverDataGateway.getReviewsByDriverId(driverId);
    }

    @Override
    public void addDriverReview(Review review) {
        driverDataGateway.addDriverReview(review);
    }

	@Override
	public Driver getDriverByID(int driverId) {
		return driverDataGateway.getDriverById(driverId);
	}

	@Override
	public Product getProductByDriverId(int driverId) {
		return driverDataGateway.getProductByDriverId(driverId);
	}

    @Override
    public double getAverageRating(int driverId) {
        List<Review> reviews = driverDataGateway.getReviewsByDriverId(driverId);
        double result = 0;
        for (Review r : reviews) {
            result += r.getRating();
        }
        result /= reviews.size();
        return result;
    }
}
