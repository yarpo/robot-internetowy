/*
 * Klasa odpowiedzialna za watki
 */
package robotinternetowy.logic;

import robotinternetowy.utils.RemoteFile;

/**
 *
 * @author yarpo
 */
public class DocumentReader implements Runnable
{
    private RemoteFile file;

    public DocumentReader(RemoteFile rfile)
    {
        file = rfile;
    }

    public void run ()
    {
        
    }
}
