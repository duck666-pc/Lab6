<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Travel Destination Detail</title>
</head>
<body>
<div class="container">
    <h1>Travel Destination Details</h1>

    <div class="detail-row">
        <span class="detail-label">ID:</span>
        <span class="detail-value">${destination.id}</span>
    </div>

    <div class="detail-row">
        <span class="detail-label">Destination Name:</span>
        <span class="detail-value">${destination.name}</span>
    </div>

    <div class="detail-row">
        <span class="detail-label">Country:</span>
        <span class="detail-value">${destination.country}</span>
    </div>

    <div class="detail-row">
        <span class="detail-label">Popularity:</span>
        <span class="detail-value">${destination.popularity}/10</span>
    </div>

    <div class="detail-row">
        <span class="detail-label">Is Visited:</span>
        <span class="detail-value">${destination.isVisited == 1 ? 'Yes' : 'No'}</span>
    </div>

    <div class="detail-row">
        <span class="detail-label">Best Season:</span>
        <span class="detail-value">${destination.bestSeason}</span>
    </div>

    <div class="button-group">
        <a href="${pageContext.request.contextPath}/travel"
           class="btn btn-secondary">Back to List</a>
        <a href="${pageContext.request.contextPath}/travel/edit?id=${destination.id}"
           class="btn btn-warning">Edit</a>

        <form action="${pageContext.request.contextPath}/travel/delete"
              method="post"
              style="display:inline;"
              onsubmit="return confirm('Are you sure you want to delete this destination?');">
            <input type="hidden" name="id" value="${destination.id}">
            <button type="submit" class="btn btn-danger">Delete</button>
        </form>
    </div>
</div>
</body>
</html>
