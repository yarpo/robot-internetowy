/*
 * Klasa pozwalajaca na walidacje danych
 */
package robotinternetowy.logic.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import robotinternetowy.utils.exceptions.ValidationException;

/**
 *
 * @author yarpo
 */
public abstract class Validator
{
    private static final String FILEPATH_REG =
            "([a-zA-Z]:(\\w+)*\\[a-zA-Z0_9]+)?";
    private static final String URL_REG =
            "^http\\://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(/\\S*)?$";

    public static String url (String url)
            throws Exception
    {
        regExpValidator(URL_REG, url);

        return url;
    }

    public static int depth (String value)
            throws Exception
    {
        return Integer.parseInt(value);
    }

    public static String saveAs (String path)
            throws Exception
    {
        regExpValidator(FILEPATH_REG, path);

        return path;
    }

    private static boolean regExpValidator (String reg, String text)
            throws Exception
    {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(text);
        if (!m.matches())
        {
            throw new ValidationException();
        }

        return true;
    }
}
