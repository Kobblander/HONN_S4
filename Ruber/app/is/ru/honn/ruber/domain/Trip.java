package is.ru.honn.ruber.domain;

public class Trip
{
    protected int id;
    protected long requestTime;
    protected int productId;
    protected TripStatus status;
    protected double distance;
    protected long startTime;
    protected long endTime;
    protected double startLat;
    protected double startLong;
    protected double endLat;
    protected double endLong;

    public Trip()
    {

    }

    public Trip(int id, long requestTime, int productId, TripStatus status, double distance, long startTime, long endTime, double startLat, double startLong, double endLat, double endLong) {
        this.id = id;
        this.requestTime = requestTime;
        this.productId = productId;
        this.status = status;
        this.distance = distance;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startLat = startLat;
        this.startLong = startLong;
        this.endLat = endLat;
        this.endLong = endLong;
    }

    public Trip(long requestTime, int productId, TripStatus status, double distance, long startTime, long endTime, double startLat, double startLong, double endLat, double endLong) {
        this.requestTime = requestTime;
        this.productId = productId;
        this.status = status;
        this.distance = distance;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startLat = startLat;
        this.startLong = startLong;
        this.endLat = endLat;
        this.endLong = endLong;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public long getRequestTime()
    {
        return requestTime;
    }

    public void setRequestTime(long requestTime)
    {
        this.requestTime = requestTime;
    }

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public TripStatus getStatus()
    {
        return status;
    }

    public void setStatus(TripStatus status)
    {
        this.status = status;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public long getStartTime()
    {
        return startTime;
    }

    public void setStartTime(long startTime)
    {
        this.startTime = startTime;
    }

    public long getEndTime()
    {
        return endTime;
    }

    public void setEndTime(long endTime)
    {
        this.endTime = endTime;
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

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", requestTime=" + requestTime +
                ", productId=" + productId +
                ", status=" + status +
                ", distance=" + distance +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startLat=" + startLat +
                ", startLong=" + startLong +
                ", endLat=" + endLat +
                ", endLong=" + endLong +
                '}';
    }
}
