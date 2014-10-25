package controllers;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.drivers.service.DriverService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.*;
import is.ru.honn.ruber.domain.Review;

import views.html.reviews;
import views.html.drivers;
import views.html.driver;

import java.util.List;

import static play.data.Form.form;

/**
 * <h1>DriverController</h1>
 * <h2>controllers</h2>
 * <p></p>
 * Created on 24.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class DriverController extends Controller {
	protected static ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/DriverService.xml");

	final static Form<Review> reviewForm = form(Review.class);

	final static DriverService service = (DriverService) ctx.getBean("driverService");

	public static Result review(int driverID) {

		Form<Review> filledForm = reviewForm.bindFromRequest();
		int rating = Integer.parseInt(filledForm.field("rating").value());
		String comment = filledForm.field("comment").value();
		Review review = new Review(driverID, rating, comment);

		service.addDriverReview(driverID, review);

		List<Review> dReviews = service.getDriverReviews(driverID);

		return ok(reviews.render(dReviews, reviewForm, driverID));
	}

	public static Result getDriverReviews(int driverID) {

		List<Review> dReviews = service.getDriverReviews(driverID);

		return ok(reviews.render(dReviews, reviewForm, driverID));
	}

	public static Result getDrivers() {
		List<Driver> allDrivers = service.getDrivers();

		return ok(drivers.render(allDrivers));
	}

	public static Result getDriver(int driverID) {
		Driver driverToView = service.getDriverByID(driverID);
		Product product = service.getProductByDriverId(driverID);

		return ok(driver.render(driverToView, product));
	}
}
