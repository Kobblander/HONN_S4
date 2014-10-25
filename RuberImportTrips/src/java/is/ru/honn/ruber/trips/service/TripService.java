package is.ru.honn.ruber.trips.service;

import is.ru.honn.ruber.trips.domain.Trip;

import java.util.List;

public interface TripService
{
    public void addTrip(int userId, Trip trip);
    public List<Trip> getTrips(int userId);
}
