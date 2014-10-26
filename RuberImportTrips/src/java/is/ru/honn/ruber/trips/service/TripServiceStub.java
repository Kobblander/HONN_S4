package is.ru.honn.ruber.trips.service;

import is.ru.honn.ruber.trips.domain.Location;
import is.ru.honn.ruber.trips.domain.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripServiceStub implements TripService
{
    List<Trip> theTrips = new ArrayList<Trip>();

    @Override
    public void addTrip(int userId, Trip trip)
    {
        theTrips.add(trip);
    }

    @Override
    public List<Trip> getTrips(int userId) {
        return theTrips;
    }

    @Override
    public List<Location> getLocations() {
        return null;
    }

}

