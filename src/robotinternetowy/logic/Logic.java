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

    public void start ()
    {
        // pobrac wszystkie dane
        // rozpoczac watek odczytujacy piuerwsza strone
        // po zanelzieniu nastepnej strony rozpoczac dla niej watek,
        //      jesli jest to dokument dozwolonego typu
    }
}
