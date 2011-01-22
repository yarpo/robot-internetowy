/*
 * Interfejs dla utrwalania danych pobranych ze strony www
 */
package robotinternetowy.persistence;

import robotinternetowy.utils.Site;

/**
 *
 * @author yarpo
 */
public interface IPersistent
{
    void save (Site site)
            throws Exception;
}
