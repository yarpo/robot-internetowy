/*
 * Wyjatek rzucay gdy jest podany nieprawidlowy typ pliku
 */
package robotinternetowy.utils.exceptions;
/**
 *
 * @author yarpo
 */
public class WrongFileContentTypeException extends RobotException
{
    public static final String MSG = "Nieprawidłowy typ pliku";

    public WrongFileContentTypeException (String msg)
    {
        super(msg);
    }

    public WrongFileContentTypeException ()
    {
        this(MSG);
    }
}
