/*
 * Klasa zapisujaca dane o stronie
 */

package robotinternetowy.persistence;

import robotinternetowy.persistence.sqlite.DataSrcSqlite;
import robotinternetowy.persistence.sqlite.data.SQLiteConn;
import robotinternetowy.utils.Site;

/**
 *
 * @author yarpo
 */
public class PersistentSQLite implements IPersistent {

    private SQLiteConn connection;

    public PersistentSQLite() throws Exception
    {
        this.connection = new SQLiteConn();
    }

    public void save (Site site)
            throws Exception
    {
        IData src = new DataSrcSqlite(this.connection.getConnection());
        try
        {
            int siteId = src.addSite(site.getAddress());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

    public void addLink (String url, String link)
            throws Exception
    {

    }

    public int howManyLinksAllreadyExistAtThisSite (String link, String url)
            throws Exception
    {
        return 1;
    }

    public int howManyLinksAllreadyExistAtThisSite (String link, int siteId)
            throws Exception
    {
        return 1;
    }

     private int getLinksCount (int siteId, String link)
            throws Exception
     {
       
        return 1;
     }

    private int getSiteIdByUrl (String url, java.sql.Date date)
            throws Exception
    {
    return 0;
    }

    public int getSiteIdByUrl (String url)
            throws Exception
    {
        return 1;
    }

}
