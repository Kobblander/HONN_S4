package is.ru.honn.ruber.trips.process;

import is.ru.honn.ruber.trips.domain.Location;
import is.ru.honn.ruber.trips.domain.Trip;
import is.ru.honn.ruber.trips.domain.TripStatus;
import is.ruframework.http.SimpleHttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * <h1>TripReader</h1>
 * <h2>is.ru.honn.ruber.drivers.process</h2>
 * <p>We changed this class around to fit our needs. It now adds mock locations from our bean.</p>
 * Created on 24.10.2014.
 *
 * @version 1.1
 */
public class TripReader
{
    TripHandler handler;

    List<Location> locations = new ArrayList<Location>();

    public TripReader() {
    }

    public void setHandler(TripHandler handler) {
        this.handler = handler;
    }

    public void read(String url) throws ProcessException {
        Logger log = Logger.getAnonymousLogger();
        URL feedUrl = null;
        try
        {
            feedUrl = new URL(url);
        }
        catch(MalformedURLException murlex)
        {
            String tmp = "URL: " + url + ", is not valid.";
            throw new ProcessException(tmp, murlex);
        }

        SimpleHttpRequest jsonRequest = new SimpleHttpRequest();
        JSONParser jsonParser = new JSONParser();

        try
        {
            String jsonString = jsonRequest.sendGetRequest(url);

            JSONObject jsonRoot = (JSONObject)jsonParser.parse(jsonString);
            JSONArray jsonHistory = (JSONArray)jsonRoot.get("history");

            for(int i=0; i<jsonHistory.size(); i++)
            {
                JSONObject jsonTrip = (JSONObject)jsonHistory.get(i);
                Trip trip = new Trip();

                trip.setId(Integer.parseInt(jsonTrip.get("uuid").toString()));
                trip.setProductId(Integer.parseInt(jsonTrip.get("product_id").toString()));
                trip.setStatus(TripStatus.COMPLETED);
                trip.setDistance((Double)jsonTrip.get("distance"));
                trip.setRequestTime(Integer.parseInt(jsonTrip.get("request_time").toString()));
                trip.setStartTime(Integer.parseInt(jsonTrip.get("start_time").toString()));
                trip.setEndTime(Integer.parseInt(jsonTrip.get("end_time").toString()));
                trip.setStartLat(locations.get(i).getStartLat());
                trip.setStartLong(locations.get(i).getStartLong());
                trip.setEndLat(locations.get(i).getEndLat());
                trip.setEndLong(locations.get(i).getEndLong());

                handler.addTrip(trip);
            }
        } catch (ParseException e) {
            String tmp = "URL is not valid.";
            throw new ProcessException(tmp, e);

        } catch (ClientProtocolException e) {
            String tmp = "URL is not valid.";
            throw new ProcessException(tmp, e);

        } catch (IOException e) {
            String tmp = "URL is not valid.";
            throw new ProcessException(tmp, e);

        }
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}



