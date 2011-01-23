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

    public UrlAddress(String h)
    {
        host = h;
    }

    public String getFullAdressForPath(String addr)
    {
        if (addr.startsWith(host))
        {
            return addr;
        }

        if (!addr.startsWith("/") && !host.endsWith("/"))
        {
            addr = "/" + addr;
        }

        return host + addr;
    }

    public boolean belongsToHost(String addr)
    {
        if (addr.startsWith(host) || addr.startsWith("/"))
        {
            return true;
        }

        return true;
    }

    public static boolean isCorrectAddress(String addr)
    {
        try
        {
            Validator.url(addr);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
