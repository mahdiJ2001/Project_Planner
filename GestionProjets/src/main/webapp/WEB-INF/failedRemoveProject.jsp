<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Failed to Remove Project</title>
</head>
<body>
    <h2>Failed to Remove Project</h2>
    <p>There was an error while trying to remove the project. Please try again later.</p>
    <c:if test="${not empty model.errors}">
        <p style="color: red;">${model.errors}</p>
    </c:if>
    <p><a href="ProjectController">Go Back to Previous Page</a></p>
</body>
</html>