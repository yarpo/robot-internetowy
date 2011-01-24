/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robotinternetowy.logic.helpers;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import robotinternetowy.utils.exceptions.ValidationException;
import static org.junit.Assert.*;

/**
 *
 * @author yarpo
 */
public class ValidatorTest
{
    public ValidatorTest ()
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
     * Test of url method, of class Validator.
     */
    @Test
    public void testUrl_ok ()
            throws Exception
    {
        VTestBuilder.isUrlCorrect("http://wp.pl/");
        VTestBuilder.isUrlCorrect("http://www.wp.pl/");
        VTestBuilder.isUrlCorrect("https://www.wp.com/?index.php");
        VTestBuilder.isUrlCorrect("HTTP://www.wp.com/");
    }

    @Test(expected=ValidationException.class)
    public void testUrl_exceptionExpected1 ()
            throws Exception
    {
        VTestBuilder.isUrlCorrect("wp.pl/");
    }

    @Test(expected=ValidationException.class)
    public void testUrl_exceptionExpected2 ()
            throws Exception
    {
        VTestBuilder.isUrlCorrect("http://wp.pl asas");
    }

    @Test(expected=ValidationException.class)
    public void testUrl_exceptionExpected3 ()
            throws Exception
    {
        VTestBuilder.isUrlCorrect("http://wp");
    }

    /**
     * Test of depth method, of class Validator.
     */
    @Test
    public void testDepth_ok ()
            throws Exception
    {
        VTestBuilder.isDepthCorrect("-1", -1);
        VTestBuilder.isDepthCorrect("-10", -10);
        VTestBuilder.isDepthCorrect("2", 2);
        VTestBuilder.isDepthCorrect("0", 0);
    }

    @Test(expected=ValidationException.class)
    public void testDepth_exceptionExp ()
            throws Exception
    {
        VTestBuilder.isDepthCorrect("sialala", 1);
    }

    /**
     * Test of saveAs method, of class Validator.
     */
    @Test
    public void testSaveAs_ok ()
            throws Exception
    {
        // pamietac, ze \\ to tak naprawde \
        VTestBuilder.isSaveAsCorrect("C:\\aaa");
        VTestBuilder.isSaveAsCorrect("C:\\aaa\\");
        // dla linuksa - trzeba zmienic FILEPATH_REG w Validation
        //VTestBuilder.isSaveAsCorrect("/root/");
    }
}
abstract class VTestBuilder
{
    public static void isUrlCorrect (String url)
            throws Exception
    {
        assertEquals(Validator.url(url), url);
    }

    public static void isDepthCorrect (String depth, int exp)
            throws Exception
    {
        assertEquals(Validator.depth(depth), exp);
    }

    public static void isSaveAsCorrect (String path)
            throws Exception
    {
        assertEquals(Validator.saveAs(path), path);
    }
}
