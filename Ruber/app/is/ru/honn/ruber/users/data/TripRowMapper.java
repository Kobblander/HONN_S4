package is.ru.honn.ruber.users.data;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <h1>RidesRowMapper</h1>
 * <h2>is.ru.honn.ruber.users.data</h2>
 * <p>This simple class maps a database row to a Trip object.</p>
 * Created on 24.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class TripRowMapper implements RowMapper<Trip> {

    @Override
    public Trip mapRow(ResultSet rs, int i) throws SQLException {
        return new Trip(rs.getInt(1),
                        rs.getLong(2),
                        rs.getInt(3),
                        TripStatus.values()[rs.getInt(4)],
                        rs.getDouble(5),
                        rs.getLong(6),
                        rs.getLong(7));
    }
}
