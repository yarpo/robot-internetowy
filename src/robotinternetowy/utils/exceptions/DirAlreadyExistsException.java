/*
 * Wyjatek rzucany, gdy katalog o podanej nazwie istnieje
 */

package robotinternetowy.utils.exceptions;

/**
 *
 * @author yarpo
 */
public class DirAlreadyExistsException extends RobotException {

    public DirAlreadyExistsException (String msg)
    {
        super(msg);
    }

    public DirAlreadyExistsException ()
    {
        this(MSG);
    }
}
