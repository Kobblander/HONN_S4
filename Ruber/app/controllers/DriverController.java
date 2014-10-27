package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.drivers.service.*;
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
import java.util.logging.Logger;

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
	private static Logger log = Logger.getLogger(DriverServiceData.class.getName());
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
					String msg = "Review not found";
					log.severe(msg + e.getMessage());
				}
				return ok();
			}
		}
	}

	public static Result getDriverReviews(int driverID) {

		ObjectNode jObj = Json.newObject();
		ArrayNode jArr = jObj.arrayNode();

		List<Review> dReviews = null;
		try {
			dReviews = service.getDriverReviews(driverID);
		} catch (DriverNotFoundException e) {
			String msg = "Driver not found";
			log.severe(msg + e.getMessage());
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
		}
		catch (DriverNotFoundException e) {
			String msg = "Driver not found";
			log.severe(msg + e.getMessage());
		}

		jObj.put("average", avgRating);

		return ok(jObj);
	}

	public static Result getDrivers() {
		List<Driver> allDrivers = null;
		try
		{
			allDrivers = service.getDrivers();
		}
		catch (DriverNotFoundException e)
		{
			String msg = "Driver not found";
			log.severe(msg + e.getMessage());
		}

		return ok(drivers.render(allDrivers));
	}

	public static Result getDriver(int driverID) {
		Driver driverToView = null;
		try
		{
			driverToView = service.getDriverByID(driverID);
		}
		catch (DriverNotFoundException e)
		{
			String msg = "Driver not found";
			log.severe(msg + e.getMessage());
		}
		Product product = null;
		try
		{
			product = service.getProductByDriverId(driverID);
		}
		catch (ProductNotFoundException e)
		{
			String msg = "Product not found";
			log.severe(msg + e.getMessage());
		}

		return ok(driver.render(driverToView, product));
	}
}
