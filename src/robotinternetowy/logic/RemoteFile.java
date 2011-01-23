/*
 * Klasa do obslugi strony. Zawiera informacje o adresie, odczytuje
 * kod oraz wyszukuje linkow
 */
package robotinternetowy.logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.ArrayList;
import robotinternetowy.PopupDialog;
import robotinternetowy.logic.helpers.HyperLinksFetcher;
import robotinternetowy.utils.exceptions.*;

/**
 *
 * @author yarpo
 */
public class RemoteFile
{
    /**
     * stala dla opcji - czytaj wszystko z domeny
     */
    public final static int NO_LIMIT = -1;
    /**
     * przechowuje informacje o adresie danej strony
     */
    private java.net.URL url;
    /**
     * obiekt potrzebny do pobrania dokumentu
     */
    private URLConnection connection;
    /**
     * tresc dokumentu trzymana w czystym stringu
     */
    private String content;
    /**
     * glebokosc na jaka maja byc odczytywane dane z domeny
     */
    private int depth;
    /**
     * lista stron do ktorych sa linki w tym dokumencie
     */
    private ArrayList<RemoteFile> links = new ArrayList<RemoteFile>();
    /**
     * dozwolone typu plikow
     */
    private static String[] allowedContentTypes =
    {
        "text/html", "text/plain"
    };

    public RemoteFile (String address, int depth)
            throws Exception
    {
        url = new java.net.URL(address);
        this.depth = depth;
        connection = url.openConnection();
    }

    public RemoteFile (String address)
            throws Exception
    {
        this(address, NO_LIMIT);
    }

    /**
     * Sprawdza, czy day typ pliku jest dozwolony
     */
    public static boolean isContentTypeAllowed (String typeGiven)
    {
        String[] types = typeGiven.split(";");

        for (String allowedType : allowedContentTypes)
        {
            if (types[0].equals(allowedType))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isContentTypeAllowed ()
    {
        String type = getContentType();
        return isContentTypeAllowed(type);
    }

    /**
     * przechwyc zawartosc dokumentu i znajdz w nim linki do innych dokumentow
     */
    public void proceed ()
            throws Exception
    {
        readContent();
        findLinks();
    }

    /**
     * odczytuje tresc dokumentu
     */
    private void readContent ()
            throws Exception
    {
        if (!isContentTypeAllowed())
        {
            throw new WrongFileContentTypeException("Nieprawidłowy typ pliku");
        }

        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                connection.getInputStream()));

        String line;
        content = "";
        while (null != (line = in.readLine()))
        {
            content += line + "\n";
        }
        in.close();
    }

    /**
     * wyszukuje linki w dokumencie
     */
    private void findLinks ()
            throws Exception
    {
        if (content.equals(""))
        {
            readContent();
        }

        fetchLinks();
    }

    /**
     * Przechwytuje linki z kodu strony
     */
    private void fetchLinks ()
            throws Exception
    {
        HyperLinksFetcher linksFetcher = new HyperLinksFetcher(content);
        ArrayList<String> addresses = linksFetcher.get();
        Integer a = addresses.size();
        int nextDepth = getNextDepth();
        //new PopupDialog().createPopupDialog(content);
        for (String fileAddress : addresses)
        {
            new PopupDialog().createPopupDialog(fileAddress);
            links.add(new RemoteFile(fileAddress, nextDepth));
        }
    }

    /**
     * Zwraca glebokosc dla kolejnego wezla - jesli jest NO_LIMIT, to zwracaj NO_LIMIT
     * w przeciwnym wypadku zmniejsz glebokosc o 1.
     */
    public int getNextDepth ()
    {
        if (NO_LIMIT >= depth)
        {
            return NO_LIMIT;
        }
        return depth - 1;
    }

    public String getFile ()
    {
        return url.getFile();
    }

    public String getHost ()
    {
        return url.getHost();
    }

    public String getPath ()
    {
        return url.getPath();
    }

    public int getPort ()
    {
        return url.getPort();
    }

    /**
     * Podaje adres do dokumentu, bez protokolu
     */
    public String getAddress ()
    {
        return getHost() + getPath();
    }

    /**
     * podaje adres do dokumentu z protokolem
     */
    public String getAddressWithProtocol ()
    {
        return getProtocol() + "://" + getAddress();
    }

    public String getProtocol ()
    {
        return url.getProtocol();
    }

    /**
     * Podaje tresc dokumentu
     */
    public String getContent ()
            throws Exception
    {
        if (content.equals(""))
        {
            readContent();
        }

        return content;
    }

    /**
     * Podaje liste dokumentow do ktorych linki znaleziono w tresci
     */
    public ArrayList<RemoteFile> getLinks ()
            throws Exception
    {
        if (links.isEmpty())
        {
            findLinks();
        }
        return links;
    }

    public int getDepth ()
    {
        return depth;
    }

    public String getContentType ()
    {
        return connection.getContentType();
    }

    public boolean isTheSameDomain (String address)
    {
        return true;
    }

    public static void setAllowedContentTypes (String[] types)
    {
        allowedContentTypes = types;
    }
}
