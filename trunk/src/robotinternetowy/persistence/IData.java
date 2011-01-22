/*
 * Interface dla klas operujacych na danych
 */
package robotinternetowy.persistence;
/**
 *
 * @author yarpo
 */
public interface IData
{
    public int addSite (String url)
            throws Exception;

    public void addLink (String url, String link)
            throws Exception;

    public int howManyLinksAllreadyExistAtThisSite (String link, String url)
            throws Exception;

    public int howManyLinksAllreadyExistAtThisSite (String link, int siteId)
            throws Exception;

    public int getSiteIdByUrl (String url)
            throws Exception;
}
