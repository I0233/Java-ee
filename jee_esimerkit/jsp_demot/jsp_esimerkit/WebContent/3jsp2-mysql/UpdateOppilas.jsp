<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<sql:setDataSource dataSource="jdbc/jeemysqlNonDs" />

<html>
    <body>
        <h1>Kannan päivitys</h1>
        <a href="<c:url value="searchFromOppilas.jsp" />" >Haku</a>
        <form>
            Id<input type=text name="id">
            Demo<input type=text name="demopisteet">
            Koe<input type=text name="koepisteet">
            <input type=submit>
        </form>

        <c:if test="${not empty param.id and not empty param.demopisteet and not empty param.koepisteet}">
            <sql:transaction>
                <sql:update sql="update oppilas set Demopisteet=?,Koepisteet=? where id = ?">
                    <sql:param>${param.demopisteet}</sql:param>
                    <sql:param>${param.koepisteet}</sql:param>
                    <sql:param>${param.id}</sql:param>
                </sql:update>
            </sql:transaction>
        </c:if>

    </body>
</html>
