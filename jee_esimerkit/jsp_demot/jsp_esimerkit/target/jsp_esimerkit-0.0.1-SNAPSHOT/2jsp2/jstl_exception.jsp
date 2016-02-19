<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

    <body>
        <form method="GET">
            Yläraja: <input type="text" name="yla"/>
            <input type="submit"/>
        </form> 
  
        <h1>Parametrien välitys ja virheenkäsittely</h1>
  
        <c:catch var="Error">
            <c:if test="${not empty param.yla && param.yla > 0}">
                <c:forEach var="i" begin="1" end="${param.yla}" step="1">
                    <b>${i}</b>  
                </c:forEach>
            </c:if>
        </c:catch>
  
 
        <c:if test="${not empty Error}">
            <i>Virheilmoitus: ${Error}</i>  
        </c:if>
    
    </body>
</html>
