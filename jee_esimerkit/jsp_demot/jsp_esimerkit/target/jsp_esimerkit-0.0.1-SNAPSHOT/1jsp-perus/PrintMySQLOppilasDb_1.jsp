<%-- 
    Document   : PrintMySQLOppilasDb
    Author     : Juha P
Kyselyt oppilas-tietokantaa sekä Event-tietokantaa
Kyselyt toteutetaan erillisessä Java-luokassa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, mysqloppilas.OppilasDb"%>
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
	try {
            OppilasDb oppDb = new OppilasDb();
            //oppDb.connectDb();  //
            ResultSet rs = oppDb.Query("select *, demopisteet+koepisteet as total," +
                    "demopisteet*id as turha, id, nimi, demopisteet-koepisteet as miinus" +
                    " from oppilas order by total asc");
            //oppDb.printOppilaat(rs, out);
            rs.beforeFirst();
            out.write(oppDb.getResultSet(rs));

            rs = oppDb.Query("select *, demopisteet+koepisteet as total " +
                    "from oppilas order by total desc");
            //oppDb.printOppilaat(rs, out);
            rs.beforeFirst();
            out.write(oppDb.getResultSet(rs));

            rs = oppDb.Query("select * " +
                    "from Event");
            //oppDb.printOppilaat(rs, out);
            rs.beforeFirst();
            out.write(oppDb.getResultSet(rs));


            oppDb.disconnectDb();
            
	} catch (SQLException sqle) {
	    while (sqle != null) {
		System.out.println(sqle.toString());
		sqle = sqle.getNextException();
	    }
	}
	catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	catch (Exception e) {
	    e.printStackTrace();
	}

        %>
    </body>
</html>
