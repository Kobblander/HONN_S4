package is.ru.honn.ruber.trips.service;

import is.ru.honn.ruber.domain.Trip;

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
    public List<Trip> getTrip(int userId)
    {
        return theTrips;
    }
}

