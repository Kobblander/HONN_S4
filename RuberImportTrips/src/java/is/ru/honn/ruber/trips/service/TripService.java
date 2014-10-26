package is.ru.honn.ruber.trips.service;

import is.ru.honn.ruber.trips.domain.Location;
import is.ru.honn.ruber.trips.domain.Trip;

import java.util.List;

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
