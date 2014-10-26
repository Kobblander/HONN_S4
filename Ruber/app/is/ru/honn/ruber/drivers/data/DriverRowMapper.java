package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <h1>DriverRowMapper</h1>
 * <h2>is.ru.honn.ruber.drivers.data</h2>
 * <p>This function maps a single row from the database into a Driver object.</p>
 * Created on 24.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class DriverRowMapper implements RowMapper<Driver> {

    @Override
    public Driver mapRow(ResultSet rs, int i) throws SQLException {
        return new Driver(rs.getInt(1),
                          rs.getString(2),
                          rs.getString(3),
                          rs.getString(4),
                          rs.getString(5),
                          rs.getString(6));
    }
}
