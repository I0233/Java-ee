<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="tuoteLuokat.Tuote,tuoteLuokat.Tuotteet"%>
<jsp:useBean id="tuote" class="tuoteLuokat.Tuote" scope="page" />
<jsp:useBean id="kori" class="tuoteLuokat.Tuotteet" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tehtävä2</title>
</head>
<body>
	<form method="POST">
	           Nimi <input type="text" name="nimi"><br/>
	           Hinta <input type="text" name="hinta"><br/>
	           Koodi <input type="text" name="koodi"><br/>
	           <input type="submit" value="Lähetä Kysely">
	</form>
	<c:if test="${not empty param.nimi and not empty param.hinta and not empty param.koodi}">
		<c:set target="${tuote}" property="nimi" value="${param.nimi}" />
		<c:set target="${tuote}" property="hinta" value="${param.hinta}" />
		<c:set target="${tuote}" property="koodi" value="${param.koodi}" />
		<% kori.setTuote(tuote);%>
		
		<b>Tuotelistaus</b>
		<c:forEach items="${kori.getTuotteet()}" var="t">
			<p>${t.nimi},${t.hinta}, ${t.koodi} </p>
		</c:forEach>
	</c:if>
</body>
</html>