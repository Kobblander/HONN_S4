package is.ru.honn.ruber.users.data;

import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.users.service.TripNotFoundException;
import is.ru.honn.ruber.users.service.UserNotFoundException;
import is.ru.honn.ruber.users.service.UsernameExistsException;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.*;

/**
 * <h1>UserData</h1>
 * <h2>is.ru.honn.ruber.users.data</h2>
 * <p>We added the functionality to get Trips to this class.</p>
 * Created on 24.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class UserData extends RuData implements UserDataGateway
{
    public int addUser(User user)
    {

        SimpleJdbcInsert insert =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("ru_users")
                        .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<String, Object>(6);
        parameters.put("username", user.getUsername());
        parameters.put("firstname", user.getFirstName());
        parameters.put("lastname", user.getLastName());
        parameters.put("password", user.getPassword());
        parameters.put("email", user.getEmail());
        parameters.put("registered", new Date());

        int returnKey = 0;

        try
        {
            returnKey = insert.executeAndReturnKey(parameters).intValue();
        }
        catch(DataIntegrityViolationException divex) {
            String msg = "No user found with username: " + user.getUsername() + ". ";
            log.severe(msg + divex.getMessage());
            throw new UsernameExistsException(msg, divex);
        }

        user.setId(returnKey);
        return returnKey;
    }

    public User getUserByUsername(String username)
    {
        Collection<String> users;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        User user;
        try
        {
            user = (User)jdbcTemplate.queryForObject( "select * from ru_users where username = '" + username + "'", new UserRowMapper());
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            String msg = "No user found with username: " + username + ". ";
            log.severe(msg + erdaex.getMessage());
            throw new UserNotFoundException(msg, erdaex);
        }
        return user;
    }

    @Override
    public List<Trip> getTripsByUserId(int userId) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        List<Trip> trips;
        try {
            trips = jdbcTemplate.query("select * from ru_trips where userId = '" + userId + "'", new TripRowMapper());
        }
        catch (EmptyResultDataAccessException erdaex) {
            String msg = "No trips were found for userID: " + userId + ". ";
            log.severe(msg + erdaex.getMessage());
            throw new TripNotFoundException(msg, erdaex);
        }
        return trips;
    }

	@Override
	public Trip getTripById(int tripId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

		Trip trip;

		try
		{
			trip = (Trip)jdbcTemplate.queryForObject("select * from ru_trips where id = '" + tripId + "'", new TripRowMapper());
		}
		catch (EmptyResultDataAccessException erdaex)
		{
            String msg = "No trip was found for tripID: " + tripId + ". ";
            log.severe(msg + erdaex.getMessage());
			throw new TripNotFoundException(msg, erdaex);
		}

		return trip;
	}
}
