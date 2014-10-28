package is.ru.honn.ruber.users.service;


public class UserNotFoundException extends RuntimeException
{

    /**
     * A constructor which only takes a message as a parameter
     * @param message The message of the error.
     */
    public UserNotFoundException(String message)
    {
        super(message);
    }

    /**
     * A constructor which both takes a message as a parameter and another
     * throwable cause.
     * @param message The message of the error.
     * @param cause Another throwable cause.
     */
    public UserNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
