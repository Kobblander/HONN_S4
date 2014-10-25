package is.ru.honn.ruber.test.gateway;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * <h1>DriverGatewayTestClient</h1>
 * <h2>is.ru.honn.ruber.test.gateway</h2>
 * <p></p>
 * Created on 25.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class DriverGatewayTestClient {

    ApplicationContext driverCtx = new FileSystemXmlApplicationContext("driverService");
}
