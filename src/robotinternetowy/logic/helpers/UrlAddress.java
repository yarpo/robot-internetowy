/*
 * Klasa pozwalajaca tworzyc pelne adresy url
 */
package robotinternetowy.logic.helpers;

import java.net.URL;
import java.util.ArrayList;
import robotinternetowy.utils.exceptions.DisallowedAddressException;

/**
 *
 * @author yarpo
 */
public class UrlAddress
{
    private URL url;
    private static final String SLASH = "/";
    private static String[] absolutePrefixes =
    {
        "http://", "https://", "ftp://", SLASH
    };
    private static ArrayList<String> allowed = null;
    private static ArrayList<String> disallowed = null;

    public UrlAddress (String h)
            throws Exception
    {
        url = new URL(h);
        checkRobotsTxt(getProtocolHost() + SLASH);
    }

    private static void checkRobotsTxt (String host)
            throws Exception
    {
        if (null == allowed && null == disallowed)
        {
            //allowed = new ArrayList<String>();
            //disallowed = new ArrayList<String>();
            RobotsTxtReader robot = new RobotsTxtReader(host);
            allowed = robot.getAllowed();
            disallowed = robot.getDisallowed();
        }
    }

    public String getProtocol ()
    {
        return url.getProtocol();
    }

    public String getHost ()
    {
        return url.getHost();
    }

    public String getFile ()
    {
        return url.getFile();
    }

    private String getProtocolHost ()
    {
        return getProtocol() + ":" + SLASH + SLASH + getHost();
    }

    public String getCurrentAddress ()
    {
        return getProtocolHost() + SLASH + getFile();
    }

    public String getCurrentDir ()
    {
        String pathToDir = getFile();
        String[] parts = pathToDir.split(SLASH);

        int n = parts.length - 1;
        if (pathToDir.endsWith(SLASH))
        {
            n++;
        }

        pathToDir = "";
        for (int i = 0; i < n; i++)
        {
            pathToDir += parts[i] + SLASH;
        }

        if (!pathToDir.endsWith(SLASH))
        {
            pathToDir += SLASH;
        }

        return getProtocolHost() + pathToDir;
    }

    @SuppressWarnings ("empty-statement")
    public String getFullAdressForPath (String addr)
            throws Exception
    {
        if (addr.startsWith(url.getHost()))
        {
            return isAddressDisallowed(addr);
        }

        if (getProtocolHost().startsWith(addr) && !addr.endsWith(SLASH))
        {
            return isAddressDisallowed(getProtocolHost() + SLASH);
        }

        if (addr.startsWith(SLASH))
        {
            return isAddressDisallowed(getProtocolHost() + addr);
        }

        if (isRelative(addr))
        {
            return isAddressDisallowed(getCurrentDir() + addr);
        }

        return isAddressDisallowed(addr);
    }

    public boolean belongsToHost (String addr)
    {
        if (addr.startsWith(getProtocolHost()))
        {
            return true;
        }

        return false;
    }

    public static boolean isRelative (String addr)
    {
        for (String start : absolutePrefixes)
        {
            if (addr.startsWith(start))
            {
                return false;
            }
        }

        return true;
    }

    public static boolean isCorrectAddress (String addr)
    {
        try
        {
            Validator.url(addr);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static String isAddressDisallowed (String addr)
            throws Exception
    {
        UrlAddress url = new UrlAddress(addr);
        for (String disallowedUrl : disallowed)
        {
            String site = url.getProtocolHost() + disallowedUrl;
            if (addr.startsWith(site))
            {
                throw new DisallowedAddressException(
                        "Strona " + addr + " nie może być odczytana");
            }
            if (disallowedUrl.startsWith("*")
                    && addr.endsWith(disallowedUrl.substring(1)))
            {
                throw new DisallowedAddressException(
                        "Zabroniony typ " + addr + " przez robots.txt");
            }
        }

        return addr;
    }
}
