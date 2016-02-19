<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!-- dataSource pitää määritellä palvelimella: Tomcatissa context.xml jossa määritellään Context elementin lapsielementti Resource. -->

<sql:setDataSource  dataSource="jdbc/jeemysqlNonDs" />

<sql:query var="rs">
    select *, koepisteet+demopisteet as total from oppilas
</sql:query>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tietokantakysely</title>
</head>
<body>
	<h1>Oppilas DB kysely</h1>
	<c:forEach var="opp" items="${rs.rows}">
            ${opp.id}, ${opp.nimi}, ${opp.demopisteet}, ${opp.koepisteet}, ${opp.total} <br />
	</c:forEach>
</body>
</html>

