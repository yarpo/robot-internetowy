/*
 * Interfejs dla utrwalania danych pobranych ze strony www
 */
package robotinternetowy.persistence;

import robotinternetowy.utils.RemoteFile;

/**
 *
 * @author yarpo
 */
public interface IPersistent
{
    void save (RemoteFile site)
            throws Exception;
}
