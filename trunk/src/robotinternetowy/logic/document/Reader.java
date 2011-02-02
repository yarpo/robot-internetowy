/*
 * Klasa odpowiedzialna za watki
 */
package robotinternetowy.logic.document;

import java.util.ArrayList;
import robotinternetowy.logger.ILogger;
import robotinternetowy.persistence.IPersistent;
import robotinternetowy.persistence.PersistentSQLite;

/**
 *
 * @author yarpo
 */
public class Reader implements Runnable
{
    public final static int DEFAULT_DOCUMENTS_LIMIT = 10;

    public static void setLogger (ILogger log)
    {
        logger = log;
    }

    private RemoteFile file;
    private IPersistent writter;
    private int docId;

    private static ILogger logger;
    private static int documents = 0;
    private static int limitOfDocuments = DEFAULT_DOCUMENTS_LIMIT;

    public Reader(RemoteFile rfile) throws Exception
    {
        file = rfile;
        writter = new PersistentSQLite();
    }

    public void run ()
    {
        try
        {
            String url = file.getAddressWithProtocol();
            logger.log("Jestem w pliku: " + url);

            docId = writter.addDocument(file);
            FileSaver.save(file);
            nextDocument();

            ArrayList<RemoteFile> links = file.getLinks();
            for (RemoteFile link : links)
            {
                String linkUrl = link.getAddressWithProtocol();
                
                logger.log("\t Dokument ["+ url +"] ma link: " + linkUrl);
                writter.addLink(docId, linkUrl);
                
                if (link.isContentTypeAllowed() &&
                       !writter.documentAlreadyRead(linkUrl) &&
                       canReadNextDocument())
                {
                    Reader nextDocument = new Reader(link);
                    (new Thread(nextDocument)).start();
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
        Reader.documents++;
    }

    private synchronized boolean canReadNextDocument ()
    {
        if (getDocumentsCounter() < getLimitOfDocuments())
        {
            return true;
        }
        return false;
    }

    public synchronized static int getLimitOfDocuments ()
    {
        return limitOfDocuments;
    }

    public synchronized static void setLimitOfDocuments (int limitOfDocuments)
    {
        Reader.documents = 0;
        Reader.limitOfDocuments = limitOfDocuments;
    }
}
