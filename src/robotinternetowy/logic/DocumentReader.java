/*
 * Klasa odpowiedzialna za watki
 */
package robotinternetowy.logic;

import java.util.ArrayList;

/**
 *
 * @author yarpo
 */
public class DocumentReader implements Runnable
{
    public final static int DEFAULT_DOCUMENTS_LIMIT = 10;

    private RemoteFile file;
    private static int documents = 0;
    private static int limitOfDocuments = DEFAULT_DOCUMENTS_LIMIT;

    public DocumentReader(RemoteFile rfile)
    {
        file = rfile;
    }

    public void run ()
    {
        try
        {
System.out.println("Jestem w pliku: " + file.getAddress());

            ArrayList<RemoteFile> links = file.getLinks();
            for(RemoteFile link : links)
            {
                if (!canReadNextDocument())
                {
System.out.println("KONIEC");
                    break;
                }

                if (link.isContentTypeAllowed())
                {
                    nextDocument();
                    System.out.println("\t ten plik ma linki" + link.getAddress());
                    DocumentReader nextDocument = new DocumentReader(link);
                    (new Thread(nextDocument)).start();
                }
                else
                {
                    System.out.println("TEGO DKUMENTU JUZ NIE CZYTAM!");
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public synchronized static int getDocumentsCounter ()
    {
        return documents;
    }

    private synchronized static void nextDocument ()
    {
        DocumentReader.documents++;
    }

    private synchronized boolean canReadNextDocument ()
    {
        if (getDocumentsCounter() >= getLimitOfDocuments())
        {
            return false;
        }
        return true;
    }

    public synchronized static int getLimitOfDocuments ()
    {
        return limitOfDocuments;
    }

    public synchronized static void setLimitOfDocuments (int limitOfDocuments)
    {
        DocumentReader.limitOfDocuments = limitOfDocuments;
    }
}
