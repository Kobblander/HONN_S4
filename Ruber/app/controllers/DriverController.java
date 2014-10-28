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
 * <p>This class is a Driver controller. It handles restful /GET requests sent with the
 * /driver/ path and it initiates responses back toward the caller. Controllers are essentially the glue between
 * the domain logic of the application and the transport layer events received as html requests.</p>
 *
 * <p>This class can add reviews, get all reviews for a specific driver, get the avarage rating of a driver,
 * and get both a single and multiple drivers.</p>
 * Created on 24.10.2014.
 *
 * @author jakob, steinar
 * @version 1.1
 */
public class DriverController extends Controller {
	protected static ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/DriverService.xml");

	private static Logger log = Logger.getLogger(DriverServiceData.class.getName());
	final static DriverService service = (DriverService) ctx.getBean("driverService");

    /**
     * This function creates a new review for a driver. It receives it as json content
     * from the request. It returns 200 OK if it was successful.
     * @param driverID The given drivers id.
     * @return
     */
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

    /**
     * This function returns all reviews for a single driver. It returns it
     * as JSON content within a OK 200 response.
     * @param driverID The given drivers id.
     * @return Returns a 200 response with driver reviews JSON content.
     */
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

    /**
     * This function returns the average rating of a driver as JSON content within a
     * 200 OK response body.
     * @param driverID The given drivers id.
     * @return Returns a 200 response with avarage rating JSON content.
     */
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

    /**
     * This function returns the driver view with all drivers.
     * @return Returns a driver view with all drivers.
     */
	public static Result getDrivers() {
		List<Driver> allDrivers = service.getDrivers();

		return ok(drivers.render(allDrivers));
	}

    /**
     * This function returns a driver view given the driversID.
     * @param driverID The given drivers id.
     * @return Returns the drivers view.
     */
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
