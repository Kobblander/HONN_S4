package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Review;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steinar on 25.10.2014.
 */
public class DriverServiceStub implements DriverService {

	List<Driver> drivers = new ArrayList<>();
	List<Review> reviews = new ArrayList<>();

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
	public void addDriverReview(int driverId, Review review) {
		reviews.add(review);
	}
}
