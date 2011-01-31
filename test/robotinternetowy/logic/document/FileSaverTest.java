/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package robotinternetowy.logic.document;

import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yarpo
 */
public class FileSaverTest {

    private static String dir = "D:\\aaa";

    public FileSaverTest() {
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
        File f = new File(dir);
        if (f.exists())
        {
            f.delete();
        }
    }

    /**
     * Test of save method, of class FileSaver.
     */
    @Test
    public void testCreateDir ()
            throws Exception
    {
        FileSaver.createDir(dir);
        File f = new File(dir);
        assertTrue(f.exists());
    }

        /**
     * Test of save method, of class FileSaver.
     */
    @Test
    public void testsave ()
            throws Exception
    {
        RemoteFile rf = new RemoteFile("http://yarpo.pl/");
        rf.proceed();
        FileSaver.setDir(dir);
        FileSaver.save(rf);
    }
}