/*
 * Klasa zapisujaca dane o stronie
 */
package robotinternetowy.persistence;

import java.util.ArrayList;
import robotinternetowy.persistence.sqlite.DataSrcSqlite;
import robotinternetowy.persistence.sqlite.SQLiteConn;
import robotinternetowy.logic.RemoteFile;

/**
 *
 * @author yarpo
 */
public class PersistentSQLite implements IPersistent
{
    private IData dataSrc;

    public PersistentSQLite ()
            throws Exception
    {
        dataSrc = new DataSrcSqlite((new SQLiteConn()).getConnection());
    }

    public int addDocument (RemoteFile file)
            throws Exception
    {
        return dataSrc.addSite(file.getAddressWithProtocol());
    }

    public void addLink (int docId, String link)
            throws Exception
    {
        dataSrc.addLink(docId, link);
    }

    public int howManyLinksAlreadyExistAtThisSite (String link, String url)
            throws Exception
    {
        return dataSrc.howManyLinksAlreadyExistAtThisSite(link, url);
    }

    public boolean documentAlreadyRead (String url)
            throws Exception
    {
        if (DataSrcSqlite.NO_RESULT == dataSrc.getSiteIdByUrl(url))
        {
            return false;
        }
        return true;
    }
}
