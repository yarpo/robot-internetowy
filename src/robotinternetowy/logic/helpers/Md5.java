/*
 * Klasa sluzaca do generowania md5
 */
package robotinternetowy.logic.helpers;

import java.security.*;
import java.math.*;

/**
 *
 * @author yarpo
 */
public class Md5
{
    private static final String ALGORITHM = "MD5";

    public static String get (String pass)
            throws Exception
    {
        MessageDigest m = MessageDigest.getInstance(ALGORITHM);
		byte[] data = pass.getBytes();
		m.update(data,0,data.length);
		BigInteger i = new BigInteger(1,m.digest());
		return String.format("%1$032X", i);
    }
}
