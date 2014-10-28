package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Product;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <h1>ProductRowMapper</h1>
 * <h2>is.ru.honn.ruber.drivers.data</h2>
 * <p>This class maps a single row from the database into a Product object.</p>
 * Created on 26.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int i) throws SQLException {
        return new Product(rs.getInt(1),
                           rs.getInt(2),
                           rs.getString(3),
                           rs.getString(4),
                           rs.getInt(5),
                           rs.getString(6));
    }
}
