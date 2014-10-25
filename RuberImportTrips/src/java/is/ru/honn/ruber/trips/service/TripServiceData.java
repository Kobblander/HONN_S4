package is.ru.honn.ruber.trips.service;

import is.ru.honn.ruber.trips.domain.Trip;
import is.ru.honn.ruber.trips.data.TripDataGateway;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.*;
import java.util.logging.Logger;

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


    private Logger log = Logger.getLogger(TripServiceData.class.getName());

    private TripDataGateway tripDataGateway;

    public TripServiceData(TripDataGateway tripDataGateway) {
        this.tripDataGateway = tripDataGateway;
    }

    @Override
    public void addTrip(int userId, Trip trip) {
        try {
            tripDataGateway.addTrip(userId, trip);
        } catch (TripExistsException e) {
            String msg = "Trip already exists: " + e.getMessage();
            log.severe(msg);
        }
    }

    @Override
    public List<Trip> getTrips(int userId) {
        List<Trip> trips = new ArrayList<Trip>();
        try {
            trips = tripDataGateway.getTripsById(userId);
        } catch (TripNotFoundException e) {
            String msg = "Trip not found: " + e.getMessage();
            log.severe(msg);
        }
        return trips;
    }
}
