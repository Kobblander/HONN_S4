package is.ru.honn.ruber.trips.process;

import is.ru.honn.ruber.trips.domain.Trip;

/**
 */

/**
 * <h1>TripHandler</h1>
 * <h2>is.ru.honn.ruber.drivers.process</h2>
 * <p>This class is a handler which is called when something happens.
 * The Tripreader has a handler, which is the TripImportProcess.</p>
 * Created on 24.10.2014.
 *
 * @version 1.1
 */
public interface TripHandler
{
    /**
     * Adds a single trip.
     * @param trip The trip.
     */
    public void addTrip(Trip trip);
}
