<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Name</title>
</head>
<body>
	<h1>List Name</h1>
	<c:out value="${names.size() }"/>
	<c:if test="${names.size() > 0}">
	<c:forEach items="${names}" var="vName">
		<h4>${vName}</h4>
	</c:forEach>
	</c:if>
</body>
</html>