/*
 * Klasa pozwalajaca na walidacje danych
 */
package robotinternetowy.logic.helpers;
/**
 *
 * @author yarpo
 */
public abstract class Validator
{
    public static String url (String url)
            throws Exception
    {
        return url;
    }

    public static int depth (String value)
            throws Exception
    {
        return Integer.parseInt(value);
    }

    public static String saveAs (String text)
            throws Exception
    {
        return text;
    }
}
