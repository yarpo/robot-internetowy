/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
public class RobotsTxtReaderTest {

    public RobotsTxtReaderTest() {
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
    public void testRead () throws Exception
    {
        RobotsTxtReader robot = new RobotsTxtReader("http://www.eti.pg.gda.pl/");
        ArrayList<String> t = robot.getAllowed();
        assertEquals(t.size(), 0);
        t = robot.getDisallowed();
        assertEquals(t.size(), 2);
    }

}