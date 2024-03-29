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

    public void addLink (String fromDocument, String link)
            throws Exception;

    public void addLink (int fromDocument, String link)
            throws Exception;

    public int howManyLinksAlreadyExistAtThisSite (String link, String url)
            throws Exception;

    public int howManyLinksAlreadyExistAtThisSite (String link, int siteId)
            throws Exception;

    public int getSiteIdByUrl (String url)
            throws Exception;
}
