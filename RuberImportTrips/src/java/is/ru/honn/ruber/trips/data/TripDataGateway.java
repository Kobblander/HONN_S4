package is.ru.honn.ruber.trips.data;

import is.ru.honn.ruber.trips.domain.Trip;
import is.ru.honn.ruber.trips.service.TripExistsException;
import is.ru.honn.ruber.trips.service.TripNotFoundException;
import is.ruframework.data.RuDataAccess;

import java.util.List;

/**
 * <h1>TripDataGateway</h1>
 * <h2>is.ru.honn.ruber.rides.data</h2>
 * <p>This simple gateweay adds a trip to the database.</p>
 * Created on 24.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public interface TripDataGateway extends RuDataAccess {
    /**
     * This function adds a single trip to the database.
     * @param userId The user ID.
     * @param trip The trip to be added.
     */
    public void addTrip(int userId, Trip trip);

    /**
     * Returns a single trip given a userId.
     * @param userId The user ID.
     * @return Returns a single trip.
     */
    public List<Trip> getTripsById(int userId);
}
