package is.ru.honn.ruber.trips.service;

import is.ru.honn.ruber.trips.domain.Location;
import is.ru.honn.ruber.trips.domain.Trip;

import java.util.List;

/**
 * <h1>TripServiceData</h1>
 * <h2>is.ru.honn.ruber.rides.service</h2>
 * <p>This class services various functionality regarding trips, you can add a Trip to the
 * database. You can get a list of trips and you can get the Location of the trips.</p>
 * Created on 24.10.2014.
 *
 * @author jakob, steinar
 * @version 1.1
 */
public interface TripService
{
    public void addTrip(int userId, Trip trip);
    public List<Trip> getTrips(int userId);

    /**
     * This function returns a list of Locations, we need to mock
     * this because we do not receive this data from the website
     * the teacher gave us.
     * @return Returns the list of locations.
     */
    public List<Location> getLocations();
}
