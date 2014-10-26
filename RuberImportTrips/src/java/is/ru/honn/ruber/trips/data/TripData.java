package is.ru.honn.ruber.trips.data;

import is.ru.honn.ruber.trips.domain.Location;
import is.ru.honn.ruber.trips.domain.Trip;
import is.ru.honn.ruber.trips.domain.TripStatus;
import is.ru.honn.ruber.trips.service.TripExistsException;
import is.ru.honn.ruber.trips.service.TripNotFoundException;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.*;

/**
 * <h1>TripData</h1>
 * <h2>is.ru.honn.ruber.rides.data</h2>
 * <p>This simple class adds a trip to the database.</p>
 * Created on 24.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class TripData extends RuData implements TripDataGateway {


    @Override
    public void addTrip(int userId, Trip trip) throws TripExistsException {

        SimpleJdbcInsert insert =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("ru_trips")
                        .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<String, Object>(6);
        parameters.put("requestTime", trip.getRequestTime());
        parameters.put("productId", trip.getProductId());
        parameters.put("status", trip.getStatus());
        parameters.put("distance", trip.getDistance());
        parameters.put("startTime", trip.getStartTime());
        parameters.put("endTime", trip.getEndTime());
        parameters.put("startLat", trip.getStartLat());
        parameters.put("startLong", trip.getStartLong());
        parameters.put("endLat", trip.getEndLat());
        parameters.put("endLong", trip.getEndLong());
        parameters.put("userId", userId);

        int returnKey = 0;
        try {
            returnKey = insert.execute(parameters);
        }
        catch(DataIntegrityViolationException divex)
        {
            throw new TripExistsException("Trip with ID: " + returnKey + " already exits", divex);
        }

    }

    @Override
    public List<Trip> getTripsById(int userId) throws TripNotFoundException {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        List<Trip> trips = new ArrayList<Trip>();
        try
        {
            trips = jdbcTemplate.query("select * from ru_trips where userId = '" + userId + "'", new TripRowMapper());
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new TripNotFoundException("No trip found with that ID", erdaex);
        }
        return trips;
    }

}
