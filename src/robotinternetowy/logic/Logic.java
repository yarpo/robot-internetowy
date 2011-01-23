/*
 * Klasa zawierajaca glowna logike programu
 */
package robotinternetowy.logic;

import robotinternetowy.logger.ILogger;

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

    public void start () throws Exception
    {
        logger.log("Startowy url: " + settings.getUrl());
        RemoteFile root = new RemoteFile(settings.getUrl(), settings.getDepth());
        if (root.isContentTypeAllowed())
        {
            logger.log("\tStartowy full : " + root.getAddressWithProtocol());
            DocumentReader document = new DocumentReader(root);
            (new Thread(document)).start();
        }

        // pobrac wszystkie dane
        // rozpoczac watek odczytujacy pierwsza strone
        // po znalezieniu nastepnej strony rozpoczac dla niej watek,
        //      jesli jest to dokument dozwolonego typu
    }
}
