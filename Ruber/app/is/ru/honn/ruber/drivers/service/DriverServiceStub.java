package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.domain.Review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>DiverServiceStub</h1>
 * <h2>is.ru.honn.ruber.drivers.service</h2>
 * This class simply stubs the information needed from the DataGateway.
 * We used this to be able to implement the controllers and the presentation layer
 * without relying on the DataGateway.
 *
 * Created by steinar on 25.10.2014.
 */
public class DriverServiceStub implements DriverService {

	public void Driver() {}

	List<Driver> drivers = new ArrayList<>();
	List<Review> reviews = new ArrayList<>();
	List<Product> products = new ArrayList<>();

	@Override
	public List<Driver> getDrivers() {
		return drivers;
	}

	@Override
	public List<Review> getDriverReviews(int driverId) {
		List<Review> dReviews = new ArrayList<>();
		for(Review r : reviews) {
			if(r.getDriverId() == driverId)
				dReviews.add(r);
		}
		return dReviews;
	}

    @Override
    public void addDriverReview(Review review) throws ReviewExistsException {

    }

	@Override
	public Driver getDriverByID(int driverID) {
		for(Driver d : drivers){
			if(d.getId() == driverID)
				return d;
		}
		return null;
	}

	@Override
	public Product getProductByDriverId(int driverID) {
		for(Product p : products) {
			if(p.getDriverId() == driverID)
				return p;
		}
		return null;
	}

    @Override
    public double getAverageRating(int driverId) {
        return 0;
    }

    public void setDrivers(List<Driver> setDrivers) {
		drivers = setDrivers;
	}

	public void setProducts(List<Product> setProducts) {
		products = setProducts;
	}

	public void setReviews(List<Review> setReviews) {
		reviews = setReviews;
	}
}
