/*
 * Interfejs dla utrwalania danych pobranych ze strony www
 */
package robotinternetowy.persistence;

import java.net.URL;

/**
 *
 * @author yarpo
 */
public interface IPersistent
{
    void save (URL site)
            throws Exception;
}
