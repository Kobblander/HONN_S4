package is.ru.honn.ruber.users.service;


public class UsernameExistsException extends RuntimeException
{
    /**
     * A constructor which only takes a message as a parameter
     * @param message The message of the error.
     */
    public UsernameExistsException(String message)
    {
        super(message);
    }

    /**
     * A constructor which both takes a message as a parameter and another
     * throwable cause.
     * @param message The message of the error.
     * @param cause Another throwable cause.
     */
    public UsernameExistsException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
