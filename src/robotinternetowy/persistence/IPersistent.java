/*
 * Interfejs dla utrwalania danych pobranych ze strony www
 */
package robotinternetowy.persistence;

import robotinternetowy.logic.RemoteFile;

/**
 *
 * @author yarpo
 */
public interface IPersistent
{
    public int addDocument (RemoteFile file)
            throws Exception;

    public void addLink (int docId, String link)
            throws Exception;

    public int howManyLinksAlreadyExistAtThisSite (String link, String url)
            throws Exception;

    public boolean documentAlreadyRead (String url)
            throws Exception;
}
