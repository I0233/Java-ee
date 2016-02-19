<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Äänestyslomake</h1>


<c:if test="${param.submitted}">
    <!-- Parsitaan numeerinen data ja käsitellään poikkeukset -->
    <c:catch var="ageParseError">
        <fmt:parseNumber var="parsedAge" value="${param.age}" scope="request"/>

        <c:if var="youngAge" test="${parsedAge < 18}" />
    </c:catch>
    <c:set var="badAge" value="${not empty ageParseError}" scope="request"/>

    <c:if test="${not empty ageParseError}">
        <div style="color:red;font-style:italic">exception: ${ageParseError}</div>
    </c:if>

    <c:if
        test="${not (empty param.name or empty param.email or empty param.age 
                or badAge or youngAge)}">
        <c:set var="name"  value="${param.name}" scope="request"/>
        <c:set var="email" value="${param.email}" scope="request"/>
        <c:set var="age"  value="${param.age}" scope="request"/>
        <jsp:forward page="formOk.jsp" />
    </c:if>
</c:if>

<form method="post">
    <input type="hidden" name="submitted" value="true" />
    <div>Nimi
        <input type="text" name="name" value="<c:out value="${param.name}"/>" />
        <c:if test="${empty param.name}">
            <p style="color:red;font-style:italic">
                Nimi tyhjä
            </p>
        </c:if>
    </div>
    <div>Sähköpostiosoite
        <input type="text" name="email" value="<c:out value="${param.email}"/>" />
        <c:if test="${empty param.email}">
            <p style="color:red;font-style:italic">
                Anna sähköpostiosoite
            </p>
        </c:if>
    </div>

    <div>
        Ika: 
        <input type="text" name="age" size="3" value="<c:out value="${param.age}"/>" />
        <c:if test="${empty param.age or badAge}">
            <p style="color:red;font-style:italic">
                Ikä ei numeerinen tai tyhjä
            </p>
        </c:if>
        <c:if test="${youngAge}">
            <p style="color:red;font-style:italic">
                Ikä alle 18 vuotta 
            </p>
        </c:if>
    </div>

    <input type="submit" value="Äänestä" />

</form>
