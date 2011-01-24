/*
 * Klasa z testami dla
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
public class UrlAddressTest
{
    public UrlAddressTest ()
    {
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
            throws Exception
    {
        String host = "http://yarpo.pl/";
        String addr = "plik.html";
        String longPath = "/aaa/vvvv/sss/asa.jtm?sdd";
        UATestBuilder o = new UATestBuilder(host).fullAddressForFileIs(addr,
                host + addr).
                fullAddressForFileIs(longPath, host + longPath);
    }

    /**
     * Test of belongsToHost method, of class UrlAddress.
     */
    @Test
    public void testBelongsToHost ()
            throws Exception
    {
        String host = "http://yarpo.pl/";
        String addr = "plik.html";
        new UATestBuilder(host).addressDoesntBelongToHost(addr).
                addressBelongToHost(host).
                addressDoesntBelongToHost("http://zdzisla.wp.pl");
    }

    @Test
    public void testIsRelative ()
            throws Exception
    {
        UATestBuilder.isFileRelative("plik.html", true);
        UATestBuilder.isFileRelative("", true);
        UATestBuilder.isFileRelative("/index", false);
        UATestBuilder.isFileRelative("ftp://", false);
    }

    /**
     * Test of isCorrectAddress method, of class UrlAddress.
     */
    @Test
    public void testIsCorrectAddress ()
    {
        UATestBuilder.isUrlCorrect("http:/ww.pl", false);
        UATestBuilder.isUrlCorrect("http://www.wp.pl", true);
        UATestBuilder.isUrlCorrect("www.wp.pl", false);
        UATestBuilder.isUrlCorrect("http://www.wp.pl.", false);
    }
}
class UATestBuilder
{
    private UrlAddress url;

    public UATestBuilder (String code)
            throws Exception
    {
        url = new UrlAddress(code);
    }

    public UATestBuilder addressBelongToHost (String addr)
    {
        assertTrue(url.belongsToHost(addr));
        return this;
    }

    public UATestBuilder addressDoesntBelongToHost (String addr)
    {
        assertFalse(url.belongsToHost(addr));
        return this;
    }

    public UATestBuilder fullAddressForFileIs (String file, String full)
    {
        assertEquals(url.getFullAdressForPath(file), full);
        return this;
    }

    public static void isFileRelative (String file, boolean value)
    {
        assertEquals(UrlAddress.isRelative(file), value);
    }

    public static void isUrlCorrect (String addr, boolean value)
    {
        assertEquals(UrlAddress.isCorrectAddress(addr), value);
    }
}
