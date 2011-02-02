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
    // dla linuksa (.*/)?(?:$|(.+?)(?:(\\.[^.]*$)|$)
    // aktualnie ustawione dla windowsa
    private static final String FILEPATH_REG =            
            "^((([a-zA-Z]:)|(\\\\{2}\\w+)\\$?)(\\\\(\\w[\\w ]*.*))+)$";
    private static final String URL_REG =
            "^http[s]?\\://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(/.*)?$";

    public static String url (String url)
            throws Exception
    {
        regExpValidator(URL_REG, url);

        return url;
    }

    public static int depth (String value)
            throws Exception
    {
        try
        {
            return Integer.parseInt(value);
        }
        catch(NumberFormatException e)
        {
            throw new ValidationException();
        }
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
        Pattern p = Pattern.compile(reg, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = p.matcher(text);
        if (!m.matches())
        {
            throw new ValidationException();
        }

        return true;
    }
}
