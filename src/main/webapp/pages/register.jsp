<%@page import="model.UserModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/register.css">

<body>
	<div class="main">
		<h1>Mobile Utopia</h1>
		<h2>Innovation In Every Hand</h2>
		<div class="container">
			<h2>Register</h2>
			<%
			String errorMessage = (String) request.getAttribute("error");

			if (errorMessage != null && !errorMessage.isEmpty()) {
			%>
			<div class="alert alert-danger" role="alert">
				<%=errorMessage%>
			</div>
			<%
			}
			%>
			<form action="${pageContext.request.contextPath}/RegisterServlet"
				method="post">
				<div class="row">
					<div class="col">

						<div class="col">
							<label for="username">Username:</label> <input type="text"
								id="username" name="username" required>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<label for="email">Email:</label> <input type="email" id="email"
								name="email" required>
						</div>
						<div class="col">
							<label for="phone">Phone Number:</label> <input type="tel"
								id="phone" name="phone" required>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<label for="address">Address:</label> <input type="text"
								id="address" name="address" required>
						</div>
						<div class="col">
							<label for="password">Password:</label> <input type="password"
								id="password" name="password" required>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<label for="confirm-password">Confirm Password:</label> <input
								type="password" id="confirm-password" name="confirm-password"
								required>
						</div>
					</div>
					<input type="submit" value="Submit">
			</form>
			   <p>Already have a account?<a href="${pageContext.request.contextPath}/pages/login.jsp">Sign In.</a></p>
			
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
