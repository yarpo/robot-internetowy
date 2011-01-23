/*
 * Wyjatek rzucany, gdy dane przekazane do pola depth sa nieprawidlowe
 */
package robotinternetowy.utils.exceptions;
/**
 *
 * @author yarpo
 */
public class DepthValidationException extends ValidationException
{
    public DepthValidationException (String msg)
    {
        super(msg);
    }

    public DepthValidationException ()
    {
        this(MSG);
    }
}
