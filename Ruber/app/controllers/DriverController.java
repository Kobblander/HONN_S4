package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.drivers.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.mvc.Controller;
import play.mvc.*;
import is.ru.honn.ruber.domain.Review;
import play.libs.Json;

import views.html.drivers;
import views.html.driver;

import java.util.List;
import java.util.logging.Logger;

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

	private static Logger log = Logger.getLogger(DriverServiceData.class.getName());
	final static DriverService service = (DriverService) ctx.getBean("driverService");

	public static Result review(int driverID) {
		JsonNode json = request().body().asJson();

        if (json == null)
            return badRequest("Expecting Json data");

        String comment = json.findPath("comment").asText();
        int rating = json.findPath("rating").asInt();

        if (comment == null)
            return badRequest("Missing parameter [comment]");

        Review review = new Review(driverID, rating, comment);
        service.addDriverReview(review);

		return ok();
	}

	public static Result getDriverReviews(int driverID) {

		ObjectNode jObj = Json.newObject();
		ArrayNode jArr = jObj.arrayNode();

		List<Review> dReviews;
		try {
			dReviews = service.getDriverReviews(driverID);

            for(Review r : dReviews) {
                ObjectNode rj = Json.newObject();
                rj.put("rating", r.getRating());
                rj.put("comment", r.getComment());
                rj.put("driverId", r.getDriverId());
                jArr.add(rj);
            }

        } catch (Exception e) {
            return badRequest();
        }

		return ok(jArr);
	}

	public static Result getAverageRating(int driverID) {
		ObjectNode jObj = Json.newObject();
		double avgRating;
		try {
            avgRating = service.getAverageRating(driverID);
            jObj.put("average", avgRating);
        }
        catch (Exception e) {
            return badRequest();
        }

		return ok(jObj);
	}

	public static Result getDrivers() {
		List<Driver> allDrivers = service.getDrivers();

		return ok(drivers.render(allDrivers));
	}

	public static Result getDriver(int driverID) {
		Driver driverToView = null;
        Product product;
        try {
            driverToView = service.getDriverByID(driverID);
            product = service.getProductByDriverId(driverID);
        } catch (Exception e) {
            return badRequest();
        }

		return ok(driver.render(driverToView, product));
	}
}
