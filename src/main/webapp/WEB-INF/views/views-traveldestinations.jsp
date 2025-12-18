<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Travel Destinations</title>
</head>
<body>
<h1>Danh sách</h1>

<a href="${pageContext.request.contextPath}/travel/new" class="btn btn-primary">Thêm mới</a>

<br><br>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Best Season</th>
        <th>Country</th>
        <th>Popularity</th>
        <th>Is Visited</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${TravelDestinations}" var="destination">
        <tr>
            <td>${destination.id}</td>
            <td>${destination.name}</td>
            <td>${destination.bestSeason}</td>
            <td>${destination.country}</td>
            <td>${destination.popularity}</td>
            <td>${destination.isVisited == 1 ? 'Yes' : 'No'}</td>
            <td class="actions">
                <a href="${pageContext.request.contextPath}/travel/detail?id=${destination.id}"
                   class="btn btn-info">Detail</a>
                <a href="${pageContext.request.contextPath}/travel/edit?id=${destination.id}"
                   class="btn btn-warning">Edit</a>

                <form action="${pageContext.request.contextPath}/travel/delete"
                      method="post"
                      style="display:inline;"
                      onsubmit="return confirm('Are you sure you want to delete this destination?');">
                    <input type="hidden" name="id" value="${destination.id}">
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
