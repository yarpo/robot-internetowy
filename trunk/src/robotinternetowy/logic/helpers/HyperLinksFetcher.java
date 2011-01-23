/*
 * Wyszukuje linki w przekazanym kodzie
 */
package robotinternetowy.logic.helpers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import robotinternetowy.PopupDialog;

/**
 *
 * @author yarpo
 */
public class HyperLinksFetcher
{
    public static final String REGEXP = "<a.+href=\"(.+?)\"";
    private String code;

    public HyperLinksFetcher (String c)
    {
        code = c;
    }

    public ArrayList<String> get ()
            throws Exception
    {
        ArrayList<String> links = new ArrayList<String>();

        Pattern pattern = Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(code);
debug(code);
        while (matcher.find())
        {
            links.add(matcher.group(1));
        }
        return links;
    }

    private void debug(String s)
    {
        System.out.println(s);
    }
}

