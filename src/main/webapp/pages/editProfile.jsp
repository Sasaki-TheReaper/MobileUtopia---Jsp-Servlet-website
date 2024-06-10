<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/edit_user.css">
<style>

.right {
    float: left;
    background-color:rgba(3, 99, 174, 0.285); 
    height: 800px;
  }
  
  .right ul {
    list-style-type: none;
    padding: 0;
    margin: 0;
  }
  
  .right ul li {
    font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    font-size: xx-large;
    font-weight:600;
    padding: 20px;
    margin-right: 40px;
  }
  
  .right ul li a {
    color: #fff;
    text-decoration: none;
  }

form {
 
  width: 400px;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f5f5f5;
  margin: 0 auto; 
}

label {
  display: block;
  margin-bottom: 5px;
}

input[type="text"],
input[type="email"],
input[type="password"] {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

input[type="submit"] {
  background-color: #4CAF50; /* Green color */
  color: white;
  padding: 10px 20px;
  border: none;
  /* Remove default button styles */
  cursor: pointer;
  /* Make the button look nicer */
  border-radius: 5px;
}

/* Add hover effect for the submit button */
input[type="submit"]:hover {
  background-color: #3e8e41; /* Darker green on hover */
}
  
</style>
</head>
<body>
<%@ include file="header.jsp" %>

<div class="right">
          <ul>
            <li><a class="active" href="#">My Account</a></li>
            <li><a href="${pageContext.request.contextPath}/pages/viewOrder.jsp">My Orders</a></li>
            <li><a href="${pageContext.request.contextPath}/pages/cart.jsp">My Cart</a></li>
            <li><a href="${pageContext.request.contextPath}/LogoutServlet">Log Out</a></li>
          </ul>
</div>

<div class="content">
      <h2 style="margin-left: 750px; margin-bottom: 40px; ">Account Information</h2>
<form method="post" action="<%= request.getContextPath() %>/UpdateProfileServlet">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" maxlength="50"><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email"  maxlength="255"><br>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address"  maxlength="255"><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" maxlength="255"><br>

    <label for="contact">Contact:</label>
    <input type="text" id="contact" name="contact"  maxlength="20"><br>

    <input type="submit" value="Edit"><br>
</form>

</div>
</body>
</html>
