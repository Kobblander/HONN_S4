package is.ru.honn.ruber.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * <h1>ServiceTestClient</h1>
 * <h2>is.ru.honn.ruber.test.service</h2>
 * <p></p>
 * Created on 25.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class ServiceTestClient {

    ApplicationContext ctx = new FileSystemXmlApplicationContext("userService");
}
