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
    void save (RemoteFile file)
            throws Exception;
}
