/*
 * Klasa obslugujaca pliki robots
 */
package robotinternetowy.logic.helpers;

import java.util.ArrayList;
import robotinternetowy.logic.document.RemoteFile;

/**
 *
 * @author yarpo
 */
public class RobotsTxtReader
{
    private String url;
    private String[] lines;
    private int lineCount;
    private ArrayList<String> disallowed = new ArrayList<String>();
    private ArrayList<String> allowed = new ArrayList<String>();

    public RobotsTxtReader (String host)
            throws Exception
    {
        url = host + "robots.txt";
        read();
    }

    public void read ()
            throws Exception
    {
        RemoteFile robots = new RemoteFile(url);
        String content = robots.getContent();
        lines = content.split("\n");
        int n = lines.length;

        for (lineCount = 0; lineCount < n; lineCount++)
        {
            readLines();
        }
    }

    private void readLines ()
    {
        String[] pair = lines[lineCount].split(": ");
        if (2 == pair.length)
        {
            if (pair[0].equals("User-agent") && pair[1].equals("*"))
            {
                for (; lineCount < lines.length; lineCount++)
                {
                    readLine();
                }
            }
        }
    }

    private void readLine ()
    {
        String[] pair = lines[lineCount].split(": ");
        if (2 == pair.length)
        {
            if (pair[0].equals("Disallow"))
            {
                disallowed.add(pair[1]);
            }
            if (pair[0].equals("Allow"))
            {
                allowed.add(pair[1]);
            }
        }
    }

    public ArrayList<String> getAllowed ()
    {
        return allowed;
    }

    public void setAllowed (ArrayList<String> allowed)
    {
        this.allowed = allowed;
    }

    public ArrayList<String> getDisallowed ()
    {
        return disallowed;
    }

    public void setDisallowed (ArrayList<String> disallowed)
    {
        this.disallowed = disallowed;
    }
}
