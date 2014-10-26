package is.ru.honn.ruber.users.service;


import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.users.data.UserDataGateway;
import is.ru.honn.ruber.domain.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class UserServiceData implements UserService
{

    private Logger log = Logger.getLogger(UserServiceData.class.getName());

    private UserDataGateway userDataGateway;

    public UserServiceData(UserDataGateway userDataGateway)
    {
        this.userDataGateway = userDataGateway;
    }

    @Override
    public User userSignup(String username, String firstName, String lastName, String password, String email, Date registered) throws UsernameExistsException
    {
        User user = new User(username, firstName, lastName, password, email, registered);
        int id = userDataGateway.addUser(user);
        user.setId(id);
        return user;
    }

    @Override
    public User getUser(String username) throws UserNotFoundException
    {
        User user = userDataGateway.getUserByUsername(username);
        if (user == null)
        {
            throw new UserNotFoundException("User not found: " + username);
        }
        return user;
    }

    @Override
    public History getUserHistory(int userId, int offset, int limit) {
        History history = new History(offset, limit, limit);
        List<Trip> trips;
        int start = offset * limit;
        int end = offset * limit + limit;

        try {
            trips = userDataGateway.getTripsByUserId(userId);
            if (trips.size() < start || limit > 100 || limit <= 0) {
                String msg = "The offset and limit parameters into getUsers are invalid. ";
                log.severe(msg);
                throw new IllegalArgumentException(msg);
            }
            if (end > trips.size() - 1) {
                end = trips.size() - 1;
            }
            trips = trips.subList(start, end);
            for (Trip t : trips) {
                history.addTrip(t);
            }
        } catch (TripNotFoundException e) {
            String msg = "Trip not found; " + e.getMessage();
            log.severe(msg);
        }

        return history;
    }

	@Override
	public Trip getTripById(int tripId) {
		Trip trip = null;
		try
		{
			trip = userDataGateway.getTripById(tripId);
		}
		catch (TripNotFoundException e)
		{
			String msg = "Trip not found; " + e.getMessage();
			log.severe(msg);
		}
		return trip;
	}

}
