package robotinternetowy.persistence.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author yarpo
 */
public class SQLiteConn
{
    protected Connection conn;

    public SQLiteConn ()
            throws Exception
    {
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:database\\robot.sqlite");
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
