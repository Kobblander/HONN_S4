package is.ru.honn.ruber.trips.data;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripStatus;
import is.ru.honn.ruber.trips.service.TripExistsException;
import is.ru.honn.ruber.trips.service.TripNotFoundException;
import is.ru.honn.ruber.users.data.UserRowMapper;
import is.ru.honn.ruber.users.service.UserNotFoundException;
import is.ruframework.data.RuData;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
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
        parameters.put("userId", userId);

        try
        {
            insert.execute(parameters);
        }
        catch(DataIntegrityViolationException divex)
        {
            throw new TripExistsException("Trip with ID: " + userId + " already exits", divex);
        }

    }

    @Override
    public List<Trip> getTripsById(int userId) throws TripNotFoundException {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        List<Trip> trips = new ArrayList<Trip>();
        try
        {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from ru_trips where userId = '" + userId + "'");
            for (Map row : rows) {
                Trip trip = new Trip();
                trip.setDistance((Double) (row.get("distance")));
                trip.setEndTime((Long) (row.get("endTime")));
                trip.setStartTime((Long) (row.get("startTime")));
                trip.setProductId((Integer)row.get("productId"));
                trip.setRequestTime((Long)(row.get("requestTime")));
                trip.setStatus(TripStatus.valueOf(row.get("tripStatus").toString()));
                trips.add(trip);
            }
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new TripNotFoundException("No trip found with that ID", erdaex);
        }
        return trips;
    }
}
