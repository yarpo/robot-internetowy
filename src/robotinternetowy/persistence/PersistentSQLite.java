/*
 * Klasa zapisujaca dane o stronie
 */

package robotinternetowy.persistence;

import robotinternetowy.persistence.sqlite.DataSrcSqlite;
import robotinternetowy.persistence.sqlite.SQLiteConn;
import robotinternetowy.logic.RemoteFile;

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

    public void save (RemoteFile file)
            throws Exception
    {
        IData src = new DataSrcSqlite(this.connection.getConnection());
        try
        {
            int siteId = src.addSite(file.getAddress());
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
}
