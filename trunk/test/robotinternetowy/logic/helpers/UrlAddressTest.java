/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package robotinternetowy.logic.helpers;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yarpo
 */
public class UrlAddressTest {

    public UrlAddressTest() {
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
     * Test of getFullAdressForPath method, of class UrlAddress.
     */
    @Test
    public void testGetFullAdressForPath_ok ()
    {
        System.out.println("getFullAdressForPath");
        String addr = "plik";
        String host = "http://yarpo.pl/";
        UrlAddress instance = new UrlAddress(host);
        String fullAddress = instance.getFullAdressForPath(addr);
        String expResult = host + addr;

        assertEquals(expResult, fullAddress);
    }

    /**
     * Test of belongsToHost method, of class UrlAddress.
     */
    @Test
    public void testBelongsToHost ()
    {
        System.out.println("testBelongsToHost");
        String addr = "plik";
        String host = "http://yarpo.pl/";
        UrlAddress instance = new UrlAddress(host);

        assertTrue(instance.belongsToHost(addr));
        assertTrue(instance.belongsToHost(host));
    }

    /**
     * Test of isCorrectAddress method, of class UrlAddress.
     */
    @Test
    public void testIsCorrectAddress ()
    {
        assertFalse(UrlAddress.isCorrectAddress("http:/ww.pl"));
        assertTrue(UrlAddress.isCorrectAddress("http://www.wp.pl"));
        assertFalse(UrlAddress.isCorrectAddress("www.wp.pl"));
        assertFalse(UrlAddress.isCorrectAddress("http://www.wp.pl."));
    }

}