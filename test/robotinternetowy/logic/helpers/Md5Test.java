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
public class Md5Test
{
    public Md5Test ()
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
     * Test of get method, of class Md5.
     */
    @Test
    public void testGet ()
            throws Exception
    {
        String[] pass =
        {
            "haslo123", "sialala", "0", "_-234124/=-=+_+@!424"
        };
        String[] expResult =
        {
            "1A7FCDD5A9FD433523268883CFDED9D0",
            "FFD39736A461558C484B724B74674782",
            "CFCD208495D565EF66E7DFF9F98764DA",
            "D27523C90B6BEBF69665E66285FDD211"
        };

        for (int i = 0; i < pass.length; i++)
        {
            assertEquals(Md5.get(pass[i].toLowerCase()), expResult[i]);
        }
    }
}
