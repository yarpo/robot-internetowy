/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package robotinternetowy.persistence.sqlite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
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
    }

    @AfterClass
    public static void tearDownClass ()
            throws Exception
    {
    }

    /**
     * Test of addSite method, of class DataSrcSqlite.
     */
    @Test
    public void testAddSite ()
            throws Exception
    {
        System.out.println("addSite");
        String url = "";
        DataSrcSqlite instance = null;
        int expResult = 0;
        int result = instance.addSite(url);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLink method, of class DataSrcSqlite.
     */
    @Test
    public void testAddLink_String_String ()
            throws Exception
    {
        System.out.println("addLink");
        String url = "";
        String link = "";
        DataSrcSqlite instance = null;
        instance.addLink(url, link);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLink method, of class DataSrcSqlite.
     */
    @Test
    public void testAddLink_int_String ()
            throws Exception
    {
        System.out.println("addLink");
        int fromDocument = 0;
        String link = "";
        DataSrcSqlite instance = null;
        instance.addLink(fromDocument, link);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of howManyLinksAllreadyExistAtThisSite method, of class DataSrcSqlite.
     */
    @Test
    public void testHowManyLinksAllreadyExistAtThisSite_String_String ()
            throws Exception
    {
        System.out.println("howManyLinksAllreadyExistAtThisSite");
        String link = "";
        String url = "";
        DataSrcSqlite instance = null;
        int expResult = 0;
        int result = instance.howManyLinksAlreadyExistAtThisSite(link, url);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of howManyLinksAllreadyExistAtThisSite method, of class DataSrcSqlite.
     */
    @Test
    public void testHowManyLinksAllreadyExistAtThisSite_String_int ()
            throws Exception
    {
        System.out.println("howManyLinksAllreadyExistAtThisSite");
        String link = "";
        int siteId = 0;
        DataSrcSqlite instance = null;
        int expResult = 0;
        int result = instance.howManyLinksAlreadyExistAtThisSite(link, siteId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSiteIdByUrl method, of class DataSrcSqlite.
     */
    @Test
    public void testGetSiteIdByUrl ()
            throws Exception
    {
        System.out.println("getSiteIdByUrl");
        String url = "";
        DataSrcSqlite instance = null;
        int expResult = 0;
        int result = instance.getSiteIdByUrl(url);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}