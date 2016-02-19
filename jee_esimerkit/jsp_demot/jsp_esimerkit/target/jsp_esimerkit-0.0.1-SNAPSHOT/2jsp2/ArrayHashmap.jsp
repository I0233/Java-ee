<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ArrayList ja HashMap</title>
    </head>
    <body>
                        
        <%
            
            java.util.ArrayList<String> kielet = new java.util.ArrayList<>();
            kielet.add("Java");
            kielet.add("C");
            kielet.add("C#");
            kielet.add("php");
            
            java.util.HashMap<String,Integer> vuodet = new java.util.HashMap<>();
            vuodet.put("Java", 1995);
            vuodet.put("C", 1971);
            vuodet.put("C#", 2000);
            vuodet.put("PHP", 1995);
            vuodet.put("Scala", 2003);
            vuodet.put("C++", 1983);
            
       %>
       <h1>ArrayList ja HashMap tulostaminen</h1>
       <% // Java Muuttujiin pääsee käsiksi näiden attribuuttien lissämisten jälkeen!
       request.setAttribute("prLanguages", kielet);
       request.setAttribute("prYears", vuodet);
       %>
       
       <h2>Ohjelmointikielet (ArrayList)</h2>
       <c:forEach var="lang" items="${prLanguages}">
           ${lang}<br/>           
       </c:forEach>
       
        <h2>Ohjelmointikielten syntyvuodet (HashMap)</h2>
        <c:forEach var="lang_year" items="${prYears}">
           ${lang_year.key} => ${lang_year.value}<br/>           
       </c:forEach>
           
    </body>
</html>
