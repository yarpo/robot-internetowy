/*
 * Klasa zawierajaca glowna logike programu
 */
package robotinternetowy.logic;

import robotinternetowy.logic.document.RemoteFile;
import robotinternetowy.logic.document.Reader;
import robotinternetowy.PopupDialog;
import robotinternetowy.logger.ILogger;
import robotinternetowy.logic.document.FileSaver;

/**
 *
 * @author yarpo
 */
public class Logic
{
    private Settings settings;
    private ILogger logger;

    public Logic (Settings set, ILogger log)
    {
        settings = set;
        logger = log;
    }

    public void start ()
            throws Exception
    {
        logger.log("Startowy url: " + settings.getUrl());
        Reader.setLimitOfDocuments(settings.getDepth());
        Reader.setLogger(logger);
        FileSaver.createDir(settings.getSaveAs());
        start(settings.getUrl());
    }

    public void start (String url)
            throws Exception
    {
        RemoteFile document = new RemoteFile(url);

        if (document.isContentTypeAllowed())
        {
            logger.log("\tObrabiam plik : " + document.getAddressWithProtocol());
            Reader docReader = new Reader(document);
            (new Thread(docReader)).start();
        }
        else
        {
            new PopupDialog().createPopupDialog(
                    "Dokument pod wskazanym adresem \n\t[" + url
                    + "]\nnie jest dozwolonego typu");
        }
    }
}
