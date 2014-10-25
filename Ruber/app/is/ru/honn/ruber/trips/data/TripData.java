package is.ru.honn.ruber.trips.data;

import is.ru.honn.ruber.domain.Trip;
import is.ruframework.data.RuData;

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
    public void addTrip(int userId, Trip trip) {

    }

    @Override
    public Trip getTrip(int userId) {
        return null;
    }
}
