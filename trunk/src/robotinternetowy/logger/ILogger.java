/*
 * Interface dla loggera
 */
package robotinternetowy.logger;
/**
 *
 * @author yarpo
 */
public interface ILogger
{
    void clear ()
            throws Exception;

    void log (String s)
            throws Exception;
}
