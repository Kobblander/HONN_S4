package is.ru.honn.ruber.test.gateway;

import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.users.data.UserDataGateway;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Date;

/**
 * <h1>GatewayTestClient</h1>
 * <h2>is.ru.honn.ruber.test.gateway</h2>
 * <p></p>
 * Created on 25.10.2014.
 *
 * @author jakob
 * @version 1.1
 */
public class UserGatewayTestClient {

    public static ApplicationContext userCtx = new FileSystemXmlApplicationContext("userService");
    public static UserDataGateway userGateway;

    public static void main(String[] args) {
        userGateway = (UserDataGateway) userCtx.getBean("userDataGateway");
        User u1 = new User("u1", "u1", "u1", "u1", "u1", new Date());
        User u2 = new User("u2", "u2", "u2", "u2", "u2", new Date());
        User u3 = new User("u3", "u3", "u3", "u3", "u3", new Date());

        userGateway.addUser(u1);
        userGateway.addUser(u2);
        userGateway.addUser(u3);

        userGateway.getUserByUsername("u1");
        userGateway.getUserByUsername("u2");
        userGateway.getUserByUsername("u3");
    }
}
