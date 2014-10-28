package controllers;

import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.Price;
import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.users.service.TripNotFoundException;
import is.ru.honn.ruber.users.service.UserService;
import is.ru.honn.ruber.users.service.UserServiceData;
import play.mvc.Controller;
import play.mvc.*;

import views.html.history;
import views.html.trip;

import java.util.logging.Logger;

/**
 * <h1>HistoryController</h1>
 * <h2>controllers</h2>
 * <p>This class is the History controller. It handles restful /GET requests sent with the
 * /history/ path and it initiates responses back toward the caller. Controllers are essentially the glue between
 * the domain logic of the application and the transport layer events received as html requests.</p>
 *
 * <p>This class returns can return a users history and a single trip given its tripID.</p>
 * Created on 24.10.2014.
 *
 * @author jakob, steinar
 * @version 1.1
 */
public class HistoryController extends UserController {

	final static UserService service = (UserService) ctx.getBean("userService");
	private static Logger log = Logger.getLogger(UserServiceData.class.getName());

    /**
     * This function returns a the history view of a single user.
     * @param userName The given users username.
     * @return Returns(renders) the history view.
     */
	public static Result getUserHistory(String userName) {

		User user = service.getUser(userName);
		History userH = null;
		try {
			userH = service.getUserHistory(user.getId(), 0, 5);
		} catch (Exception e) {
            userH = service.getUserHistory(user.getId(), 0, 5);
		}

		return ok(history.render(userH));
	}

    /**
     * This function returns a trip view for a given tripID.
     * @param tripID The given tripID.
     * @return Returns(renders) the trip view.
     */
	public static Result getTripById(int tripID) {
		Trip vTrip;
		try {
			vTrip = service.getTripById(tripID);
		} catch (TripNotFoundException e) {
            return badRequest();
		}
		return ok(trip.render(vTrip));
	}

}
