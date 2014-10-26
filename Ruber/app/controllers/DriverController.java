package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.drivers.service.DriverNotFoundException;
import is.ru.honn.ruber.drivers.service.DriverService;
import is.ru.honn.ruber.drivers.service.ProductNotFoundException;
import is.ru.honn.ruber.drivers.service.ReviewExistsException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.*;
import is.ru.honn.ruber.domain.Review;
import play.libs.Json;

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
		System.out.println(driverID);
		System.out.println(request().body().asRaw());
		System.out.println(request().body().toString());
		System.out.println(request().body().asText());
		JsonNode json = request().body().asJson();
		System.out.println(json);
		if(json == null) {
			return badRequest("Expecting Json data");
		} else {
			String comment = json.findPath("comment").asText();
			int rating = json.findPath("rating").asInt();
			if(comment == null) {
				return badRequest("Missing parameter [comment]");
			} else {
				Review review = new Review(driverID, rating, comment);
				try {
					service.addDriverReview(review);
				} catch (ReviewExistsException e) {
					e.printStackTrace();
				}
				return ok();
			}
		}

		/*Form<Review> filledForm = reviewForm.bindFromRequest();
		int rating = Integer.parseInt(filledForm.field("rating").value());
		String comment = filledForm.field("comment").value();
		Review review = new Review(driverID, rating, comment);

		service.addDriverReview(driverID, review);

		List<Review> dReviews = service.getDriverReviews(driverID);

		return ok(reviews.render(dReviews, reviewForm, driverID));*/
	}

	public static Result getDriverReviews(int driverID) {

		ObjectNode jObj = Json.newObject();
		ArrayNode jArr = jObj.arrayNode();

		List<Review> dReviews = null;
		try {
			dReviews = service.getDriverReviews(driverID);
		} catch (DriverNotFoundException e) {
			e.printStackTrace();
		}

		for(Review r : dReviews) {
			ObjectNode rj = Json.newObject();
			rj.put("rating", r.getRating());
			rj.put("comment", r.getComment());
			rj.put("driverId", r.getDriverId());
			jArr.add(rj);
		}

		return ok(jArr);
	}

	public static Result getAverageRating(int driverID) {
		ObjectNode jObj = Json.newObject();
		double avgRating = -1;
		try {
			avgRating = service.getAverageRating(driverID);
		} catch (DriverNotFoundException e) {
			e.printStackTrace();
		}

		jObj.put("average", avgRating);

		return ok(jObj);
	}

	public static Result getDrivers() {
		List<Driver> allDrivers = null;
		try {
			allDrivers = service.getDrivers();
		} catch (DriverNotFoundException e) {
			e.printStackTrace();
		}

		return ok(drivers.render(allDrivers));
	}

	public static Result getDriver(int driverID) {
		Driver driverToView = null;
		try {
			driverToView = service.getDriverByID(driverID);
		} catch (DriverNotFoundException e) {
			e.printStackTrace();
		}
		Product product = null;
		try {
			product = service.getProductByDriverId(driverID);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}

		return ok(driver.render(driverToView, product));
	}
}
