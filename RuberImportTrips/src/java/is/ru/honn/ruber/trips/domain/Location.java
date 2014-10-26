package is.ru.honn.ruber.trips.domain;

/**
 * <h1>Location</h1>
 * <h2>is.ru.honn.ruber.trips.domain</h2>
 * <p>This is a class used to mock location data which we
 * receive from the service bean.</p>
 * Created on 26.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class Location {

    protected double startLat;
    protected double startLong;
    protected double endLat;
    protected double endLong;

    public Location() {
    }

    public double getStartLat() {
        return startLat;
    }

    public void setStartLat(double startLat) {
        this.startLat = startLat;
    }

    public double getStartLong() {
        return startLong;
    }

    public void setStartLong(double startLong) {
        this.startLong = startLong;
    }

    public double getEndLat() {
        return endLat;
    }

    public void setEndLat(double endLat) {
        this.endLat = endLat;
    }

    public double getEndLong() {
        return endLong;
    }

    public void setEndLong(double endLong) {
        this.endLong = endLong;
    }
}
