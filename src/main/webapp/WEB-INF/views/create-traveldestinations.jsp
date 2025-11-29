<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Travel Destination</title>
</head>
<body>
<div class="container">
    <h1>Add New Travel Destination</h1>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/travel/new" method="post">
        <div class="form-group">
            <label for="name">Destination Name: *</label>
            <input type="text" id="name" name="name" required>
        </div>

        <div class="form-group">
            <label for="country">Country: *</label>
            <input type="text" id="country" name="country" required>
        </div>

        <div class="form-group">
            <label for="popularity">Popularity (1-10): *</label>
            <input type="number" id="popularity" name="popularity"
                   min="1" max="10" required>
        </div>

        <div class="form-group">
            <label for="isVisited">Is Visited: *</label>
            <select id="isVisited" name="isVisited" required>
                <option value="0">No</option>
                <option value="1">Yes</option>
            </select>
        </div>

        <div class="form-group">
            <label for="bestSeason">Best Season: *</label>
            <input type="text" id="bestSeason" name="bestSeason"
                   placeholder="e.g., Spring, Summer, Fall, Winter" required>
        </div>

        <div class="button-group">
            <button type="submit" class="btn btn-primary">Add Destination</button>
            <a href="${pageContext.request.contextPath}/travel"
               class="btn btn-secondary">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
