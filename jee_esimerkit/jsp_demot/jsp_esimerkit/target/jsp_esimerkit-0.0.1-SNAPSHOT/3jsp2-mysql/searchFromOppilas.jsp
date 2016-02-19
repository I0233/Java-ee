<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<html>
<body>
	<a href="<c:url value="UpdateOppilas.jsp" />">Päivitys</a>

	<form>
		Anna hakunimi: <input type=text name=nimi><input type=submit
			value="hae nimellä">
	</form>

	<sql:query var="selectQuery" dataSource="jdbc/jeemysqlNonDs"> SELECT id,nimi,demopisteet+koepisteet as total 
            FROM oppilas where nimi like ? order by total desc
            <sql:param>%${param.nimi}%</sql:param>
	</sql:query>

	<table border="2">
		<c:forEach items="${selectQuery.rows}" var="row">
			<tr>
				<c:forEach items="${row}" var="item">
					<td>${item.value}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
