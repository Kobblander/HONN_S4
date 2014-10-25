package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.drivers.service.DriverService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.mvc.Controller;
import play.mvc.*;
import is.ru.honn.ruber.domain.Review;

import views.html.reviews;
import views.html.drivers;

import java.util.List;

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

	public static Result review(int driverID) {

		DriverService service = (DriverService) ctx.getBean("driverService");

		System.out.println(driverID);
		JsonNode json = request().body().asJson();
		if(json == null)
			return badRequest("No data sent");
		String sRating = json.findPath("rating").textValue();
		if(sRating == null)
			return badRequest("No rating sent");
		String comment = json.findPath("comment").textValue();
		int rating = Integer.parseInt(sRating);

		Review review = new Review(driverID, rating, comment);

		service.addDriverReview(driverID, review);

		return ok("Success!");
	}

	public static Result getDriverReviews(int driverID) {
		DriverService service = (DriverService) ctx.getBean("driverService");

		List<Review> dReviews = service.getDriverReviews(driverID);

		return ok(reviews.render(dReviews));
	}

	public static Result getDrivers() {
		DriverService service = (DriverService) ctx.getBean("driverService");

		List<Driver> allDrivers = service.getDrivers();

		return ok(drivers.render(allDrivers));
	}
}
