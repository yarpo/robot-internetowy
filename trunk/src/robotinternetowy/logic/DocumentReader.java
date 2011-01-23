/*
 * Klasa odpowiedzialna za watki
 */
package robotinternetowy.logic;

import java.util.ArrayList;
import robotinternetowy.PopupDialog;

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
        try
        {
            new PopupDialog().createPopupDialog("Jestem tutak");
            file.proceed();

            new PopupDialog().createPopupDialog(file.getContent());
            ArrayList<RemoteFile> links = file.getLinks();
            for(RemoteFile link : links)
            {
                if (link.isContentTypeAllowed())
                {
                    DocumentReader nextDocument = new DocumentReader(link);
                    (new Thread(nextDocument)).start();
                }
                new PopupDialog().createPopupDialog("Odczytuję " + file.getAddressWithProtocol());
            }
        }
        catch(Exception e)
        {
            
        }
        
    }
}
