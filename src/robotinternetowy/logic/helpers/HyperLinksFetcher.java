/*
 * Wyszukuje linki w przekazanym kodzie
 */
package robotinternetowy.logic.helpers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author yarpo
 */
public class HyperLinksFetcher
{
    //"<a.+href\\s*=\\s*(\"([^\"](.+?)\")|'[^'](.+?)')[^>]*>[^<]*</a>"; 115
    public static final String REGEXP = "<a.+href\\s*=\\s*(\"([^\"](.+?)\")|'[^'](.+?)')";
            
    private String code;

    public HyperLinksFetcher (String c)
    {
        code = c;
    }

    public ArrayList<String> get ()
    {
        ArrayList<String> links = new ArrayList<String>();

        Pattern pattern = Pattern.compile(REGEXP, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(code);

        while (matcher.find())
        {
            links.add(matcher.group(1).substring(1, matcher.group(1).length()-1));
        }
        return links;
    }
}

