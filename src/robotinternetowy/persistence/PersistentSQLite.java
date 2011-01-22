/*
 * Klasa zapisujaca dane o stronie
 */

package robotinternetowy.persistence;

import java.net.URL;

/**
 *
 * @author yarpo
 */
public class PersistentSQLite implements IPersistent {

    private SQLiteConn connection;

    public PersistentSQLite()
    {
        this.connection = new SQLiteConn();
    }

    public void save (URL site)
            throws Exception
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
