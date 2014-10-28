package is.ru.honn.ruber.trips.process;

import is.ru.honn.ruber.trips.domain.Trip;
import is.ru.honn.ruber.trips.service.TripService;
import is.ru.honn.ruber.trips.service.TripServiceData;
import is.ruframework.process.RuAbstractProcess;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * <h1>TripImportProcess</h1>
 * <p>This process extends the ru-framework RuAbstractProcess and is a process in the context of the
 * ru-framework.</p>
 * <p>This class is the receiving end of the <em>"hollywood principle"</em> in this project. This class is a handler
 * for JSONReaders and processes Trips for them by sending them forward to the Ruber Service.</p>
 *
 * @author jakob, steinar, teacher.
 * Created on 27.9.2014.
 */
public class TripImportProcess extends RuAbstractProcess implements TripHandler
{
    TripService tripService;
    TripReader reader = new TripReader();
    Logger log = Logger.getAnonymousLogger();

    @Override
    public void beforeProcess()
    {
        ApplicationContext appCtx = new FileSystemXmlApplicationContext("TripService.xml");
        tripService = (TripService)appCtx.getBean("tripService");
        reader.setHandler(this);
        reader.setLocations(tripService.getLocations());
    }

    @Override
    public void startProcess()
    {
        List<Trip> trips = new ArrayList();
        try
        {
            reader.read(getProcessContext().getImportURL());
        }
        catch (ProcessException e)
        {
            String message = "Error reading importfile: ";
            log.severe(message + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void afterProcess()
    {
        List<Trip> trips = tripService.getTrips(1);
        for(Trip trip : trips)
        {
            System.out.println(trip);
        }
    }

    @Override
    public void addTrip(Trip trip)
    {
        tripService.addTrip(1, trip);
    }
}
