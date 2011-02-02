/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package robotinternetowy.utils.exceptions;

/**
 *
 * @author yarpo
 */
public class DisallowedAddressException extends RobotException {

    public DisallowedAddressException (String msg)
    {
        super(msg);
    }

    public DisallowedAddressException ()
    {
        this(MSG);
    }
}

