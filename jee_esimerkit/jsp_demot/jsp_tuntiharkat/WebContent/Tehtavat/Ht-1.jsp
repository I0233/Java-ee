<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tuntiharjoitus 1</title>
</head>
<body>
	<h2>Tuntiharjoitus 1</h2>
	<fieldset>Tee Java Servlet-ohjelma, joka tulostaa komentorivillä annetun nimen</fieldset><br>
	
	<p>Etunimesi: <c:if test="${not empty param.etunimi}">${param.etunimi}</c:if></p>
	<p>Sukunimesi: <c:if test="${not empty param.sukunimi}">${param.sukunimi}</c:if></p>
</body>
</html>