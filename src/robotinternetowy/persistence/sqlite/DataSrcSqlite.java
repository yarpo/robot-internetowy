/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robotinternetowy.persistence.sqlite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.Date;
import robotinternetowy.persistence.IData;

/**
 *
 * @author yarpo
 */
public class DataSrcSqlite implements IData
{
    public static final String SITES_TABLE_NAME = "documents";
    public static final String LINKS_TABLE_NAME = "links";
    public static final int NO_RESULT = -1;
    protected Connection conn;

    public DataSrcSqlite (Connection conn)
    {
        this.conn = conn;
    }

    public int addSite (String url)
            throws Exception
    {
        String query = "INSERT INTO " + SITES_TABLE_NAME
                + " (url, date)"
                + " values (?, ?);";
debug(query);
        PreparedStatement ps = this.conn.prepareStatement(query);
        java.sql.Date date = convertDateUtil2Sql(new Date());
        ps.setString(1, url);
        ps.setDate(2, date);
        ps.executeUpdate();

        return getSiteIdByUrl(url, date);
    }

    public void addLink (String url, String link)
            throws Exception
    {
        int siteId = getSiteIdByUrl(url);
        addLink(siteId, link);
    }

    public void addLink (int fromDocument, String link)
            throws Exception
    {
        String query = "INSERT INTO " + LINKS_TABLE_NAME
                + " (id_from_document, url)"
                + " values (?, ?);";
debug(query);
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt(1, fromDocument);
        ps.setString(2, link);
        ps.executeUpdate();
    }

    private void debug(String s)
    {
        System.out.println(s);
    }


    public int howManyLinksAllreadyExistAtThisSite (String link, String url)
            throws Exception
    {
        int id = getSiteIdByUrl(url);
        return getLinksCount(id, link);
    }

    public int howManyLinksAllreadyExistAtThisSite (String link, int siteId)
            throws Exception
    {
        return getLinksCount(siteId, link);
    }

     private int getLinksCount (int siteId, String link)
            throws Exception
     {
        String query = "SELECT count(id) as number FROM " + LINKS_TABLE_NAME
                + " WHERE id_from_document = ? AND url = ?";
debug(query);
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt(1, siteId);
        ps.setString(2, link);

        ResultSet result = ps.executeQuery();
        int count = NO_RESULT;

        if (result.next())
        {
            count = result.getInt("number");
        }

        result.close();
        ps.close();

        return count;
     }

    private int getSiteIdByUrl (String url, java.sql.Date date)
            throws Exception
    {
        String query = createSQLForGetSiteIdByUrl(date);
debug(query);
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, url);
        ps.setDate(2, date);

        ResultSet result = ps.executeQuery();
        int id = NO_RESULT;

        if (result.next())
        {
            id = result.getInt("id");
        }

        result.close();
        ps.close();

        return id;
    }

    public int getSiteIdByUrl (String url)
            throws Exception
    {
        return getSiteIdByUrl(url, null);
    }

    private String createSQLForGetSiteIdByUrl(Date date)
    {
        String query = "SELECT id FROM " + SITES_TABLE_NAME
                + " WHERE url = ? ";
        if (null != date)
        {
             query += " AND date = ?";
        }
        return query;
    }

    private java.sql.Date convertDateUtil2Sql (Date date)
    {
        return new java.sql.Date(date.getTime());
    }
}
