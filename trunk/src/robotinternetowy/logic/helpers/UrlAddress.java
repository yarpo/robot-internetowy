/*
 * Klasa pozwalajaca tworzyc pelne adresy url
 */
package robotinternetowy.logic.helpers;
/**
 *
 * @author yarpo
 */
public class UrlAddress
{
    private String host;
    private static String SLASH = "/";
    private static String[] absolutePrefixes =
    {
        "http://", "https://", "ftp://", SLASH
    };

    public UrlAddress (String h)
    {
        host = h;
    }

    public String getFullAdressForPath (String addr)
    {
        if (addr.startsWith(host))
        {
            return addr;
        }

        if (host.startsWith(addr) && !addr.endsWith(SLASH))
        {
            return host;
        }

        if (!addr.startsWith(SLASH) && !host.endsWith(SLASH))
        {
            addr = SLASH + addr;
        }

        return host + addr;
    }

    public boolean belongsToHost (String addr)
    {
        if (addr.startsWith(host) || addr.startsWith(host.substring(0, host.length()-1)) || addr.startsWith(SLASH))
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
}
