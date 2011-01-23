/*
 * Wyjatek rzucany, gdy podany url jest nieprawidlowy
 */
package robotinternetowy.utils.exceptions;
/**
 *
 * @author yarpo
 */
public class UrlValidationException extends ValidationException
{
    public UrlValidationException (String msg)
    {
        super(msg);
    }

    public UrlValidationException ()
    {
        this(MSG);
    }
}
