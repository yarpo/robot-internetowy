/*
 * Klasa pozwalajaca tworzyc pelne adresy url
 */
package robotinternetowy.logic.helpers;

import java.net.URL;

/**
 *
 * @author yarpo
 */
public class UrlAddress
{
    private URL url;
    private static String SLASH = "/";
    private static String[] absolutePrefixes =
    {
        "http://", "https://", "ftp://", SLASH
    };

    public UrlAddress (String h) throws Exception
    {
        url = new URL(h);
    }

    public String getProtocol()
    {
        return url.getProtocol();
    }

    public String getHost()
    {
        return url.getHost();
    }

    public String getFile()
    {
        return url.getFile();
    }

    private String getProtocolHost()
    {
        return getProtocol() + ":" + SLASH+SLASH + getHost();
    }

    public String getCurrentAddress()
    {
        return getProtocolHost() + SLASH + getFile();
    }

    public String getCurrentDir()
    {
        String pathToDir = getFile();
        String [] parts = pathToDir.split(SLASH);

        int n = parts.length-1;
        if (pathToDir.endsWith(SLASH))
        {
            n++;
        }

        pathToDir = "";
        for(int i = 0; i < n; i++)
        {
            pathToDir += parts[i] + SLASH;
        }

        if (!pathToDir.endsWith(SLASH))
        {
            pathToDir += SLASH;
        }

        return getProtocolHost() + pathToDir;
    }

    public String getFullAdressForPath (String addr)
    {
        if (addr.startsWith(url.getHost()))
        {
            return addr;
        }

        if (getProtocolHost().startsWith(addr) && !addr.endsWith(SLASH))
        {
            return getProtocolHost() + SLASH;
        }

        if (addr.startsWith(SLASH))
        {
            return getProtocolHost() + SLASH + addr;
        }

        return addr;
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
}
