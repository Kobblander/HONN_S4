package is.ru.honn.ruber.domain;

/**
 * <h1>Review</h1>
 * <h2>is.ru.honn.ruber.domain</h2>
 * <p>A simple POJO represing one review which is attached to a
 * single driver.</p>
 * Created on 24.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class Review {

    private int id;
    private int driverId;
    private int rating;
    private String comment;

    public Review() {
    }

    public Review(int id, int driverId, int rating, String comment) {
        this.id = id;
        this.driverId = driverId;
        this.rating = rating;
        this.comment = comment;
    }

    public Review(int driverId, int rating, String comment) {
        this.driverId = driverId;
        this.rating = rating;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "comment='" + comment + '\'' +
                ", rating=" + rating +
                ", driverId=" + driverId +
                ", id=" + id +
                '}';
    }
}
