/*
 * Wyjatek rzucany, gdy nie sa podane prawidlowe dane
 */
package robotinternetowy.utils.exceptions;
/**
 *
 * @author yarpo
 */
public class ValidationException extends RobotException
{
    public static final String MSG = "Niepoprawne dane";

    public ValidationException (String msg)
    {
        super(msg);
    }

    public ValidationException ()
    {
        this(MSG);
    }
}
