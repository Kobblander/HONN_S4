package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.domain.Review;
import is.ru.honn.ruber.drivers.service.DriverNotFoundException;
import is.ru.honn.ruber.drivers.service.ProductNotFoundException;
import is.ru.honn.ruber.drivers.service.ReviewExistsException;
import is.ru.honn.ruber.drivers.service.ReviewNotFoundException;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.*;

/**
 * <h1>DriverData</h1>
 * <h2>is.ru.honn.ruber.drivers.data</h2>
 * <p>This class implements the DriverDataGateway and thusly handles the connection
 * to the database. This class also extends RuData which supplies the DataSource. The
 * DriverService config file supplies the datasource.</p>
 * Created on 24.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class DriverData extends RuData implements DriverDataGateway {

    @Override
    public void addDriverReview(Review review) throws ReviewExistsException {
        SimpleJdbcInsert insert =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("ru_reviews")
                        .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("driverId", review.getDriverId());
        parameters.put("rating", review.getRating());
        parameters.put("comment", review.getComment());

        insert.execute(parameters);
    }

    @Override
    public Driver getDriverById(int driverId) throws DriverNotFoundException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        Driver driver;
        try {
            driver = (Driver)jdbcTemplate.queryForObject("select * from ru_drivers where id = '" + driverId + "'", new DriverRowMapper());
        } catch (EmptyResultDataAccessException erdaex) {
            String msg = "No driver found with ID: " + driverId + "that driver id. ";
            log.severe(msg);
            throw new DriverNotFoundException(msg + erdaex.getMessage());
        }
        return driver;
    }

    @Override
    public List<Review> getReviewsByDriverId(int driverId) throws DriverNotFoundException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        List<Review> reviews;
        try {
            reviews = jdbcTemplate.query("select * from ru_reviews where driverId = '" + driverId + "'", new ReviewRowMapper());
        } catch (EmptyResultDataAccessException erdaex) {
            String msg = "No reviews found for driverID: " + driverId + ". ";
            log.severe(msg);
            throw new ReviewNotFoundException(msg + erdaex.getMessage());
        }
        return reviews;
    }

    @Override
    public List<Driver> getDrivers() throws DriverNotFoundException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        List<Driver> drivers;
        try {
            drivers = jdbcTemplate.query("select * from ru_drivers", new DriverRowMapper());
        } catch (EmptyResultDataAccessException erdaex) {
            drivers = new ArrayList<Driver>();
        }
        return drivers;
    }

    @Override
    public Product getProductByDriverId(int driverId) throws ProductNotFoundException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        Product product;
        try {
            product = (Product)jdbcTemplate.queryForObject("select * from ru_products where driverId = '" + driverId + "'", new ProductRowMapper());
        } catch (EmptyResultDataAccessException erdaex) {
            String msg = "No product for driverID: " + driverId + " was found.";
            log.severe(msg);
            throw new ProductNotFoundException(msg + erdaex.getMessage());
        }
        return product;
    }


}
