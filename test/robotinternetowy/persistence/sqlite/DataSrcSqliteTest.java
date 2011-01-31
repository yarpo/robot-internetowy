/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package robotinternetowy.persistence.sqlite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import robotinternetowy.persistence.IData;
import static org.junit.Assert.*;

/**
 *
 * @author yarpo
 */
public class DataSrcSqliteTest {

    public DataSrcSqliteTest() {
    }

    @BeforeClass
    public static void setUpClass ()
            throws Exception
    {
        DataSrcSqlite data = new DataSrcSqlite((new SQLiteConn()).getConnection());
        data.trunk();
    }

    @AfterClass
    public static void tearDownClass ()
            throws Exception
    {
        DataSrcSqlite data = new DataSrcSqlite((new SQLiteConn()).getConnection());
        data.trunk();
    }

    /**
     * Test of addSite method, of class DataSrcSqlite.
     */
    @Test
    public void testAddSite_ok ()
            throws Exception
    {
        IData data = new DataSrcSqlite((new SQLiteConn()).getConnection());
        String url = "http://yarpo.pl";
        int res1 =  data.addSite(url);
        int res2 = data.getSiteIdByUrl(url);
        assertEquals(res1, res2);
    }

    /**
     * Test of addLink method, of class DataSrcSqlite.
     */
    @Test
    public void testAddLink_String_String ()
            throws Exception
    {
        IData data = new DataSrcSqlite((new SQLiteConn()).getConnection());
        String url = "http://yarpo.pl/";
        String link = url + "plik.html";
        data.addSite(url);
        data.addLink(url, link);
        int res = data.howManyLinksAlreadyExistAtThisSite(link, url);
        assertEquals(res, 1);
    }

    /**
     * Test of addLink method, of class DataSrcSqlite.
     */
    @Test
    public void testAddLink_Int_String ()
            throws Exception
    {
        IData data = new DataSrcSqlite((new SQLiteConn()).getConnection());
        String url = "http://yarpo.pl/";
        String link = url + "plik.html";
        int id = data.addSite(url);
        data.addLink(id, link);
        int res = data.howManyLinksAlreadyExistAtThisSite(link, url);
        assertEquals(res, 1);
    }
}