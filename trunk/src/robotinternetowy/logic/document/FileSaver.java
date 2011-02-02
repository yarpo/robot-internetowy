/*
 * Klasa do zapisywania tresci do plikow
 */
package robotinternetowy.logic.document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import robotinternetowy.logic.helpers.Md5;
import robotinternetowy.utils.exceptions.DirAlreadyExistsException;

/**
 *
 * @author yarpo
 */
public abstract class FileSaver
{
    private static String dir;
    private static boolean dirCreated = false;
    private static String slash = "\\";
    private static String extension = ".html";

    public static void setExtension (String extension)
    {
        FileSaver.extension = extension;
    }

    public static void setSlash (String slash)
    {
        FileSaver.slash = slash;
    }

    public static void save (RemoteFile document)
            throws Exception
    {
        String filePath = getFilePath(document.getAddressWithProtocol());
        File f = new File(filePath);
        f.createNewFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
        out.write(document.getContent());
        out.close();
    }

    private static String getFilePath(String doc) throws Exception
    {
        return dir + slash + Md5.get(doc) + extension;
    }

    public static void createDir (String d)
            throws Exception
    {
        File f = new File(d);
        if (f.exists())
        {
            throw new DirAlreadyExistsException("Taki folder już istnije " + d);
        }

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
