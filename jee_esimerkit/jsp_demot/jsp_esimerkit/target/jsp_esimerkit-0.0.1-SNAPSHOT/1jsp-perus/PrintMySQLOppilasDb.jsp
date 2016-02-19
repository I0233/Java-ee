<%-- 
    Document   : PrintMySQLOppilasDb
    Author     : Juha P
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>MySQL kysely</h1>
        <%
            String user = "root";
            String passwd = "root66";
             String url = "jdbc:mysql://localhost:3306/jdbcesim";

            Connection conn = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, passwd);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from oppilas");
                while (rs.next()) {
                    // retrieve and print the values for the current database row
                    int id = rs.getInt("id");
                    String nimi = rs.getString("nimi");
                    int demo = rs.getInt("demopisteet");
                    int koe = rs.getInt("koepisteet");
                    out.println("<div>" + id + "," + nimi + "," + demo + "," + koe + "</div>");
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException sqle) {
                while (sqle != null) {
                    System.out.println(sqle.toString());
                    sqle = sqle.getNextException();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        %>
    </body>
</html>
