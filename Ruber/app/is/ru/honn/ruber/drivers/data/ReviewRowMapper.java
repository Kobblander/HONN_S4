package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Review;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <h1>ReviewRowMapper</h1>
 * <h2>is.ru.honn.ruber.drivers.data</h2>
 * <p></p>
 * Created on 26.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class ReviewRowMapper implements RowMapper<Review> {

    @Override
    public Review mapRow(ResultSet rs, int i) throws SQLException {
        return new Review(rs.getInt(1),
                          rs.getInt(2),
                          rs.getInt(3),
                          rs.getString(4));
    }
}
