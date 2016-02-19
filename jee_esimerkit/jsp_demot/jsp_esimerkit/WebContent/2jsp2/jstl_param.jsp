<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>    


<html>

    <body>
        <form method="GET">
            Yläraja: <input type="text" name="yla"/>
            Syötä Tiedot pilkulla erotettuna<input type="text" name="info">
            <input type="submit"/>
        </form> 
  
        <%-- ${olio.ominaisuus} --%>  
  
        <h1>Parametrien välitys</h1>
        <c:catch var="Virheilmoitus">
            <c:if test="${not empty param.yla && param.yla > 0}">
                <c:forEach var="i" begin="1" end="${param.yla}" step="1">
                    <b>${i}</b>  
                </c:forEach>
            </c:if>
        </c:catch>
    
        <br/>
    
        <%-- VOidaan pilkkoa merkkijono erotinmerkin perusteella --%>
        <c:forTokens var="item" items="${param.info}" delims=",">
    ${item}<br/>
        </c:forTokens>  
  
  
        <c:if test="${not empty Virheilmoitus}">
            <i style="color:red">Virheilmoitus: ${Virheilmoitus}</i>  
        </c:if>
    
    </body>
</html>
