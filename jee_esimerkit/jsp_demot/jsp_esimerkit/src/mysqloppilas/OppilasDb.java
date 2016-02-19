/*
 * Jatkoharjoitus JSP III:
- Mieti luokkarakenne, jossa tietokantayhteys hoidetaan
Alla yksi vaihtoehto:
connectDb()
Query()
printResultSet(String resultType)  tai getResultSet()
disconnectDb()

 */
package mysqloppilas;

import java.io.IOException;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Administrator
 */
public class OppilasDb {

    private String user = "root";
    private String passwd = "root66";
    private String url = "jdbc:mysql://localhost:3306/jdbcesim";
    private Connection conn = null;

    public OppilasDb() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, passwd);
    }

    public ResultSet Query(String sql) throws SQLException {

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    public String getOppilaat(ResultSet rs) throws SQLException, IOException {
    	StringBuilder out = new StringBuilder();
        while (rs.next()) {
            // retrieve and print the values for the current database row
            int id = rs.getInt("id");
            String nimi = rs.getString("nimi");
            int demo = rs.getInt("demopisteet");
            int koe = rs.getInt("koepisteet");
            out.append("<div>" + id + "," + nimi + "," + demo + "," + koe + "</div>");
        }
        rs.close();
        return out.toString();
    }
    // Geneerisempi tulostusmetodi

    public String getResultSet(ResultSet rs) throws SQLException, IOException {
    	StringBuilder out = new StringBuilder();
        // a) Hakee tulosjoukon kenttien nimet
        ArrayList<String> cols = this.getColumnNames(rs);
        out.append("<table>");
        out.append("<tr>");
        // b) Tietokannan otsikkotiedot kenttien nimien perusteella
        for (String c : cols) {
            out.append("<th>" + c + "</th>");
        }
        out.append("</tr>");
        // c) Tulostetaan Tietokannan data kenttien nimien perusteella
        while (rs.next()) {
            out.append("<tr>");
            for (String c : cols) {
                out.append("<td>" + rs.getString(c) + "</td>");
            }
            out.append("</tr>");

        }
        out.append("</table>");
        rs.close();
        return out.toString();
    }

    public ArrayList<String> getColumnNames(ResultSet resultSet) throws
            SQLException {
        ArrayList<String> columnNames = new ArrayList<String>();
        ResultSetMetaData meta = resultSet.getMetaData();
        int count = meta.getColumnCount();
        for (int c = 1; c <= count; c++) {
            columnNames.add(meta.getColumnLabel(c));
        }
        return columnNames;
    }

    public void disconnectDb() throws SQLException {
        conn.close();
    }
}
