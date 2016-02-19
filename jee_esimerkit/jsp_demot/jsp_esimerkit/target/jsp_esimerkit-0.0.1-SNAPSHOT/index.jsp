<%-- 
    Document   : index
    Author     : Juha Peltomäki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP TESTIsivu</title>
    </head>
    <body>
        <h1>Esimerkit Java Web-ohjelmoinnista</h1>
        <a href="servlet/AjaEkaServletti.html">servlet</a><br>
        <a href="1jsp-perus/PrintMySQLOppilasDb.jsp">JSP 1</a><br>
        <a href="2jsp2/TuoteOstoskori.jsp">JSP 2 ja JSTL</a><br>
        <a href="3jsp2-mysql/searchFromOppilas.jsp">JSP 2 ja MySQL</a><br>
        <div>Lisää esimerkkejä ajamalla JSP-tiedostoa suoraan projektissa</div>
        
        <div>
        <% String str = "Testataan JSP-sivua ihan omasta Java-koodista";
        out.write(str);        
        %>
        </div>
    </body>
</html>
