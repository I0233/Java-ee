<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aikojen tulostaminen</title>
    </head>
    <body>
        <h2>Aikojen tulostamista</h2>

        <%-- Luodaan uusi java.util.Date() objekti nimeltään time1  --%>
        <jsp:useBean id="time1" class="java.util.Date"/>
        <%-- Asetetaan ajalle arvo (Date.setTime() avulla ) --%>
        <c:set target="${time1}" property="time" value="${pageContext.session.creationTime}" />
        Creation time: (Oletuslokaalit englanninkielisinä tässä järjestelmässä)
        <fmt:formatDate value="${time1}" type="both" dateStyle="medium" /><br/>
        <fmt:formatDate value="${time1}" type="both" dateStyle="short" /><br/>
        <fmt:formatDate value="${time1}" type="both" dateStyle="long"/><br/>

        <%-- JATKOTEHTÄVÄ: Halutaan vaihtaa lokaaliasetukset esim. Suomi
        <fmt:setLocale>, jonne asetetaan maakoodeina lokaaliasetus --%>


        <fmt:setLocale value="fi" scope="session"/>
        <c:set target="${time1}" property="time" value="${pageContext.session.lastAccessedTime}" />
        <h2>Access time: (lokaaleja eri kielillä)</h2>
        <fmt:formatDate value="${time1}" type="both" dateStyle="long"/><br/>

        <fmt:setLocale value="fr" scope="session"/>
        <fmt:formatDate value="${time1}" type="both" dateStyle="long"/><br/>
        <fmt:setLocale value="sv" scope="session"/>
        <fmt:formatDate value="${time1}" type="both" dateStyle="long"/><br/>

    </body>
</html>
