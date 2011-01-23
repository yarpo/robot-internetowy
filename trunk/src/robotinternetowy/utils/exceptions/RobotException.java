/*
 * Klasa bazowa dla wszystkich wyjatkow rzucanych w aplikacji
 */
package robotinternetowy.utils.exceptions;
/**
 *
 * @author yarpo
 */
public class RobotException extends Exception
{
    public static final String MSG =
            "Wystąpił wyjątek w aplikacji robotinternetowy";

    public RobotException (String msg)
    {
        super(msg);
    }

    public RobotException ()
    {
        this(MSG);
    }
}
