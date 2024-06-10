 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/login.css">


</head>
<body>
<div class="main">
    <h1>Mobile Utopia</h1>
    <h2>Innovation In Every Hand</h2>
    <div class="container">
        <h2>Login</h2>
        <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
            <label for="email">Email:</label> <input type="email" id="email" name="email" required><br>
            <label for="password">Password:</label> <input type="password" id="password" name="password" required><br>
            <input type="submit" value="Log in"><br>
            <p>Don't have a account?<a href="${pageContext.request.contextPath}/pages/register.jsp">Sign Up.</a></p>
        </form>
        <% 
        String successMessage = (String) request.getAttribute("error");
        String errorMessage = (String) request.getAttribute("error");

        if (errorMessage != null && !errorMessage.isEmpty()) {
        %>
        <!-- Display error message -->
        <div class="alert alert-danger mt-2" role="alert">
            <%= errorMessage %>
        </div>
        <% } %>

        <% 
        if (successMessage != null && !successMessage.isEmpty()) {
        %>
        <!-- Display success message -->
        <div class="alert alert-success mt-2" role="alert">
            <%= successMessage %>
        </div>
        <% } %>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

 