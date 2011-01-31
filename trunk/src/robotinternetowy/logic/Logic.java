/*
 * Klasa zawierajaca glowna logike programu
 */
package robotinternetowy.logic;

import java.util.ArrayList;
import robotinternetowy.PopupDialog;
import robotinternetowy.logger.ILogger;

/**
 *
 * @author yarpo
 */
public class Logic
{
    private Settings settings;
    private ILogger logger;
    private int documentsLimit;
    private int documentsRead;

    public Logic (Settings set, ILogger log)
    {
        settings = set;
        logger = log;
        documentsLimit = settings.getDepth();
        documentsRead = 0;
    }



    public void start () throws Exception
    {
        logger.log("Startowy url: " + settings.getUrl());
        start(settings.getUrl());

        // pobrac wszystkie dane
        // rozpoczac watek odczytujacy pierwsza strone
        // po znalezieniu nastepnej strony rozpoczac dla niej watek,
        //      jesli jest to dokument dozwolonego typu
    }

    private synchronized void increaseDocumentsCounter()
    {
        documentsRead++;
    }

    public void start (String url) throws Exception
    {
        RemoteFile document = new RemoteFile(url);

        if (document.isContentTypeAllowed())
        {
            increaseDocumentsCounter();
            logger.log("\tObrabiam plik : " + document.getAddressWithProtocol());
            DocumentReader docReader = new DocumentReader(document);
            (new Thread(docReader)).start();
        }
        else
        {
            new PopupDialog().createPopupDialog("Dokument pod wskazanym adresem \n\t" + url + "\nnie jest dozwolonego typu");
        }
    }
}
