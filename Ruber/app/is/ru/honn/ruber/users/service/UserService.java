package is.ru.honn.ruber.users.service;

import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.User;

import java.util.Date;

/**
 * <h1>UserService</h1>
 * <h2>is.ru.honn.ruber.users.service</h2>
 * <p>This interface services various functionality pertaining to users. The teacher
 * supplied most of the functions but we added out own functions to be able to get the trip
 * history of a user and to be able to get a single trip.</p>
 * Created on 25.10.2014.
 *
 * @author jakob, steinar
 * @version 1.1
 */
public interface UserService
{
    public User userSignup(String username, String firstName, String lastName,
                           String password, String email, Date registered)
            throws UsernameExistsException;

    public User getUser(String username) throws UserNotFoundException;

    /**
     * This function returns a history of trips for a single user.
     * This function also supports pagination. If asking for too many
     * trips there will be a cutoff.
     * @param userId The given users id.
     * @param offset The offset wanted into the returned trips.
     * @param limit How many trips are wanted.
     * @return Returns a history object.
     */
    public History getUserHistory(int userId, int offset, int limit);

    /**
     * This function returns a trip given a tripID.
     * @param tripId The given trip id
     * @return Returns a trip.
     */
	public Trip getTripById(int tripId);
}
