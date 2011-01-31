/*
 * Klasa odpowiedzialna za watki
 */
package robotinternetowy.logic.document;

import java.util.ArrayList;
import robotinternetowy.logger.ILogger;
import robotinternetowy.logic.RemoteFile;
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
            int documentId = 0;
            logger.log("Jestem w pliku: " + url);

            if (!writter.documentAlreadyRead(url))
            {
                documentId = writter.addDocument(file);
            }
            else
            {
                // byl czytany, albo wlasnie jest odczytywany. Nie ma sensu czytac ponownie
                return;
            }

            ArrayList<RemoteFile> links = file.getLinks();
            for (RemoteFile link : links)
            {
                if (!canReadNextDocument())
                {
                    logger.log("Koniec");
                    break;
                }

                String linkUrl = link.getAddressWithProtocol();

                if (writter.documentAlreadyRead(linkUrl))
                {
                    writter.addLink(documentId, linkUrl);
                    // ten link juz odczytany, wez kolejny
                    continue;
                }

                if (link.isContentTypeAllowed())
                {
                    nextDocument();
                    logger.log("\t Dokument ["+ url +"] ma link: " + linkUrl);
                    Reader nextDocument = new Reader(link);
                    (new Thread(nextDocument)).start();
                }
                else
                {
                    logger.log("\t Ten dokument [" +linkUrl+"] jest nieprawidłwego typu.");
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
        Reader.limitOfDocuments = limitOfDocuments;
    }
}
