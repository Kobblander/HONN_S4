package is.ru.honn.ruber.trips.process;

public class ProcessException extends Exception
{
    public ProcessException()
    {
        super();
    }

    public ProcessException(String message)
    {
        super(message);
    }

    public ProcessException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
