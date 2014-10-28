package is.ru.honn.ruber.users.data;

import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.users.service.TripNotFoundException;
import is.ruframework.data.RuDataAccess;

import java.util.List;

/**
 * <h1>UserDataGateway</h1>
 * <h2>is.ru.honn.ruber.users.data</h2>
 * <p>We added the functionality to get Trips to this class.</p>
 * Created on 24.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public interface UserDataGateway extends RuDataAccess
{
    public int addUser(User user);
    public User getUserByUsername(String username);

    /**
     * This function returns a history for a single user.
     * @param userId The users id.
     * @return Returns a single history object.
     */
    public List<Trip> getTripsByUserId(int userId) throws TripNotFoundException;

	public Trip getTripById(int tripId) throws TripNotFoundException;
}