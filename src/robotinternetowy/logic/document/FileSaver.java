/*
 * Klasa do zapisywania tresci do plikow
 */
package robotinternetowy.logic.document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import robotinternetowy.logic.helpers.Md5;

/**
 *
 * @author yarpo
 */
public abstract class FileSaver
{
    private static String dir;
    private static boolean dirCreated = false;

    public static void save (RemoteFile document)
            throws Exception
    {
        String filePath = dir + "\\" + Md5.get(document.getAddressWithProtocol());
        File f = new File(filePath);
        f.createNewFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
        out.write(document.getContent());
        out.close();
    }

    public static void createDir (String d)
            throws Exception
    {
        File f = new File(d);
        if (f.mkdir())
        {
            dirCreated = true;
            dir = d;
        }
    }

    public static void setDir (String dir)
    {
        FileSaver.dir = dir;
    }
}
