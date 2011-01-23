/*
 * Wyjatek rzucany, gdy sciezka do pliku jest nieprawidlowa
 */

package robotinternetowy.utils.exceptions;

/**
 *
 * @author yarpo
 */
public class PathValidationException extends ValidationException
{
    public PathValidationException (String msg)
    {
        super(msg);
    }

    public PathValidationException ()
    {
        this(MSG);
    }
}
