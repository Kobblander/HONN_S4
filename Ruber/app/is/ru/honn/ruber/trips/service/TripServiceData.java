package is.ru.honn.ruber.trips.service;

import is.ru.honn.ruber.domain.Trip;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>RidesData</h1>
 * <h2>is.ru.honn.ruber.rides.service</h2>
 * <p></p>
 * Created on 24.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class TripServiceData implements TripService {

    @Override
    public int addTrip(int userId, Trip trip) throws TripExistsException {

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
        parameters.put("uuid", userId);

        int returnKey;

        try
        {
            returnKey = insert.executeAndReturnKey(parameters).intValue();
        }
        catch(DataIntegrityViolationException divex)
        {
            throw new TripExistsException("Trip with ID: " + userId + " already exits", divex);
        }

        trip.setId(returnKey);
        return returnKey;

    }

    @Override
    public List<Trip> getTrip(int userId) {
        return null;
    }
}
