<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Travel Destination</title>
</head>
<body>
<div class="container">
    <h1>Edit Travel Destination</h1>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/travel/edit?id=${destination.id}"
          method="post">

        <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" id="id" name="id" value="${destination.id}"
                   class="readonly" readonly>
        </div>

        <div class="form-group">
            <label for="name">Destination Name: *</label>
            <input type="text" id="name" name="name"
                   value="${destination.name}" required>
        </div>

        <div class="form-group">
            <label for="country">Country: *</label>
            <input type="text" id="country" name="country"
                   value="${destination.country}" required>
        </div>

        <div class="form-group">
            <label for="popularity">Popularity (1-10): *</label>
            <input type="number" id="popularity" name="popularity"
                   value="${destination.popularity}"
                   min="1" max="10" required>
        </div>

        <div class="form-group">
            <label for="isVisited">Is Visited: *</label>
            <select id="isVisited" name="isVisited" required>
                <option value="0" ${destination.isVisited == 0 ? 'selected' : ''}>No</option>
                <option value="1" ${destination.isVisited == 1 ? 'selected' : ''}>Yes</option>
            </select>
        </div>

        <div class="form-group">
            <label for="bestSeason">Best Season: *</label>
            <input type="text" id="bestSeason" name="bestSeason"
                   value="${destination.bestSeason}"
                   placeholder="e.g., Spring, Summer, Fall, Winter" required>
        </div>

        <div class="button-group">
            <button type="submit" class="btn btn-primary">Update Destination</button>
            <a href="${pageContext.request.contextPath}/travel/detail?id=${destination.id}"
               class="btn btn-secondary">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
