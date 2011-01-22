/*
 * Klasa do obslugi Url
 */
package robotinternetowy.utils;
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
        download();
        findLinks();
    }

    private void download()
    {

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
