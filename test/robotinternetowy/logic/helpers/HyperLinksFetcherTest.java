/*
 * Testy dla HyperLinksFetcher
 */
package robotinternetowy.logic.helpers;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yarpo
 */
public class HyperLinksFetcherTest
{
    public HyperLinksFetcherTest ()
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

    @Test
    public void testGet_simple_ok ()
            throws Exception
    {
        new HLFTestBulder(
                "<a href=\"test\">tekst</a>\n<a href=\"test2\">tekst</a>").
                expectedResultsNo(2).
                atPositionIsValue(0, "test").
                atPositionIsValue(1, "test2");
    }

    @Test
    public void testGet_badHTML_Result0 ()
            throws Exception
    {
        new HLFTestBulder("<a href='test'tekst</a>").expectedResultsNo(0);
    }

    @Test
    public void testGet_validHTML_Result0 ()
            throws Exception
    {
        new HLFTestBulder("<p href=\"ssadasd\">").expectedResultsNo(0);
    }

    @Test
    public void testGet_validHTMLwithAtrr_Result1 ()
            throws Exception
    {
        new HLFTestBulder(
                "<p><a clas=\"sdsd sdsa aa\" name=\"dsfgdf\" href=\"aaaaa\" id=\"aaaa\"></a></p>").
                expectedResultsNo(1).
                atPositionIsValue(0, "aaaaa");
    }

    @Test
    public void testGet_validHTMLwithSingleQoute_Result1 ()
            throws Exception
    {
        new HLFTestBulder("<p><a href='aaaaa' id=\"aaaa\"></a></p>").
                expectedResultsNo(1).
                atPositionIsValue(0, "aaaaa");
    }
}
class HLFTestBulder
{
    private ArrayList<String> result;

    public HLFTestBulder (String code)
            throws Exception
    {
        HyperLinksFetcher fetcher = new HyperLinksFetcher(code);
        result = fetcher.get();
    }

    public HLFTestBulder atPositionIsValue (int position, String value)
    {
        assertEquals(result.get(position), value);
        return this;
    }

    public HLFTestBulder expectedResultsNo (int n)
    {
        assertEquals(result.size(), n);
        return this;
    }
}
