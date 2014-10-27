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
 * Created by steinar on 26.10.2014.
 */
public class HistoryController extends UserController {

	final static UserService service = (UserService) ctx.getBean("userService");
	private static Logger log = Logger.getLogger(UserServiceData.class.getName());

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

	public static Result getTripById(int tripID) {
		Trip vTrip = null;
		try {
			vTrip = service.getTripById(tripID);
		} catch (TripNotFoundException e) {
			String msg = "Trip not found";
			log.severe(msg + e.getMessage());
		}
		if(vTrip == null)
			return badRequest();
		return ok(trip.render(vTrip));
	}

}
