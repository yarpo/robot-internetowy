package robotinternetowy.persistence.sqlite.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author michal
 */
public class SQLiteConn
{
    protected Connection conn;

    public SQLiteConn ()
            throws Exception
    {
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:database.db");
    }

    public SQLiteConn (String con)
            throws Exception
    {
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection(con);
    }

    public Connection getConnection ()
    {
        return this.conn;
    }
}
