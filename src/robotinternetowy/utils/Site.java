/*
 * Klasa do obslugi Url
 */
package robotinternetowy.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author yarpo
 */
public class Site
{
    private java.net.URL url;
    private String code;

    public Site (String address)
            throws Exception
    {
        url = new java.net.URL(address);
        readCode();
        findLinks();
    }

    private void readCode() throws Exception
    {
        URLConnection connection = url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    connection.getInputStream()
                )
        );
        String line;

        while (null != (line = in.readLine()))
        {
            code += line;
        }
        in.close();
    }

    private void findLinks()
    {
        
    }

    public String getFile ()
    {
        return url.getFile();
    }

    public String getHost ()
    {
        return url.getHost();
    }

    public String getPath ()
    {
        return url.getPath();
    }

    public int getPort ()
    {
        return url.getPort();
    }

    public String getAddress ()
    {
        return getHost() + getPath();
    }

    public String getCode()
    {
        return code;
    }
}
