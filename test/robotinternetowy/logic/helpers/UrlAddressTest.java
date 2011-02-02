/*
 * Klasa z testami dla
 */
package robotinternetowy.logic.helpers;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import robotinternetowy.utils.exceptions.DisallowedAddressException;
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
    public void testGetCurrentDir ()
            throws Exception
    {
        String host = "http://www.eti.pg.gda.pl/a";
        new UATestBuilder(host).currentDirIs("http://www.eti.pg.gda.pl/").next(
                "http://www.eti.pg.gda.pl/").currentDirIs(
                "http://www.eti.pg.gda.pl/").next("http://www.eti.pg.gda.pl/a/").
                currentDirIs("http://www.eti.pg.gda.pl/a/").next(
                "http://www.eti.pg.gda.pl/a.html").currentDirIs(
                "http://www.eti.pg.gda.pl/").next(
                "http://www.eti.pg.gda.pl/a/b/c").currentDirIs(
                "http://www.eti.pg.gda.pl/a/b/").next(
                "http://www.eti.pg.gda.pl/a/b/c/").currentDirIs(
                "http://www.eti.pg.gda.pl/a/b/c/");
    }

    @Test
    public void testGetFullPath ()
            throws Exception
    {
        String host = "http://www.eti.pg.gda.pl/";
        new UATestBuilder(host).fullAddressForFileIs("/wydzial/",
                "http://www.eti.pg.gda.pl/wydzial/").fullAddressForFileIs(
                "/katedry/kaims/",
                "http://www.eti.pg.gda.pl/katedry/kaims/");
    }

    @Test
    public void testBelongsToHost ()
            throws Exception
    {
        String host = "http://yarpo.pl/";
        String addr = "plik.html";
        new UATestBuilder(host).addressDoesntBelongToHost(addr).
                addressBelongToHost(host).addressDoesntBelongToHost(
                "http://zdzisla.wp.pl");
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

    @Test
    public void testIsCorrectAddress ()
    {
        UATestBuilder.isUrlCorrect("http:/ww.pl", false);
        UATestBuilder.isUrlCorrect("http://www.wp.pl", true);
        UATestBuilder.isUrlCorrect("www.wp.pl", false);
        UATestBuilder.isUrlCorrect("http://www.wp.pl.", false);
    }

    @Test (expected = DisallowedAddressException.class)
    public void testDisallowedAddressException ()
            throws Exception
    {
        new UATestBuilder("http://www.eti.pg.gda.pl/").fullAddressForFileIs(
                "plik.rss", "aa");
    }
}
class UATestBuilder
{
    private UrlAddress url;

    public UATestBuilder (String addr)
            throws Exception
    {
        url = new UrlAddress(addr);
    }

    public UATestBuilder next (String addr)
            throws Exception
    {
        url = new UrlAddress(addr);
        return this;
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
            throws Exception
    {
        assertEquals(url.getFullAdressForPath(file), full);
        return this;
    }

    public UATestBuilder currentDirIs (String exp)
    {
        assertEquals(exp, url.getCurrentDir());
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
