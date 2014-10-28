package is.ru.honn.ruber.trips.process;

/**
 * <h1>ProcessException</h1>
 * <h2>is.ru.honn.ruber.trips.process</h2>
 * <p>A simple expression which is thrown when something in the process goes wrong.</p>
 * Created on 25.10.2014.
 *
 * @author jakob, steinar
 * @version 1.1
 */
public class ProcessException extends Exception
{
    /**
     * A constructor which only takes a message as a parameter
     * @param message The message of the error.
     */
    public ProcessException(String message)
    {
        super(message);
    }

    public ProcessException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
