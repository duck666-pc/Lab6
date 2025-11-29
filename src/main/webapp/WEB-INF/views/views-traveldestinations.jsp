<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Travel Destinations</title>
</head>
<body>
<h1>List of Travel Destinations</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Country</th>
        <th>Popularity</th>
        <th>Is Visited</th>
        <th>Best season</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${TravelDestinations}" var="TravelDestinations">
        <tr>
            <td>${TravelDestinations.id}</td>
            <td>${TravelDestinations.name}</td>
            <td>${TravelDestinations.country}</td>
            <td>${TravelDestinations.popularity}</td>
            <td>${TravelDestinations.isVisited}</td>
            <td>${TravelDestinations.bestSeason}</td>
            <td>
                <a href="${pageContext.request.contextPath}/TravelDestinations/delete?id=${TravelDestinations.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
