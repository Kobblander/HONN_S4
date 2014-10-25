package is.ru.honn.ruber.users.data;

import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.users.service.TripNotFoundException;
import is.ruframework.data.RuDataAccess;

import java.util.List;

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
}