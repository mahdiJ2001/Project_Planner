<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Failed to Update Project</title>
</head>
<body>
    <h2>Failed to Update Project</h2>
    <p>There was an error updating the project information. Please try again later.</p>
        <c:if test="${not empty model.errors}">
        <p style="color: red;">${model.errors}</p>
    </c:if>
    <p><a href="ProjectController">Go Back to Previous Page</a></p>
</body>
</html>