/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package robotinternetowy.persistence.sqlite;

import java.sql.Connection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yarpo
 */
public class SQLiteConnTest {

    public SQLiteConnTest() {
    }

    @BeforeClass
    public static void setUpClass ()
            throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass ()
            throws Exception
    {
    }

    /**
     * Test of getConnection method, of class SQLiteConn.
     */
    @Test
    public void testGetConnection () throws Exception
    {
        try
        {
            SQLiteConn instance = new SQLiteConn();
            Connection expResult = null;
            Connection result = instance.getConnection();
            assertNotSame(expResult, result);
        }
        catch(Exception e)
        {
            fail("Błąd: \t" + e.toString());
        }
        
    }

}