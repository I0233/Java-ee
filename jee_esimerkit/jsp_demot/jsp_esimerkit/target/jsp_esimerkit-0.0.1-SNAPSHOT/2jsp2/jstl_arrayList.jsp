<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>

<html>
<body>

<% // Sijoitetaan tuotteita Arraylist-rakenteeseen (dynaaminen taulukko) 
  ArrayList<String> al = new ArrayList<>();
  al.add("Maito"); al.add("Makkara"); al.add("Piim‰"); al.add("Olut"); 
  al.add("Hampurilainen");
  // Asetetaan Arraylist-oliossa oleva tieto t‰m‰n sivun attributtiin lista
  // jolloin siihen p‰‰st‰‰n k‰siksi JSTL:st‰ k‰sin forEach-silmukassa
  pageContext.setAttribute("lista", al);
%>



<h3>K‰yd‰‰n ArrayList l‰pi</h3>
 <c:set var="laskuri" value="1"/>
 <c:forEach items="${lista}" var="item" >
   ${laskuri}.${item}<br/>
   <c:set var="laskuri" value="${laskuri+1}"/>
   <% // Luetaan JSTL-muuttujan arvo Java-koodiin 
      Object arvo = pageContext.getAttribute("laskuri");
      String str = arvo.toString();
      int val = Integer.parseInt(str);      
      out.println("Javasta tulostettu laskuri:" + val + "</br>");
   %>
</c:forEach>



</body>
</html>