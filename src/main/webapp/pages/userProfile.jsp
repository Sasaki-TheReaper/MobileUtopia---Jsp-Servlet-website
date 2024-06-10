
<%@ page import="Controller.*" %>
<%@ page import="model.UserModel" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ include file="header.jsp" %>  
 <%
DatabaseController controller = new DatabaseController();
UserModel user = controller.getUserByEmail(email);
%>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/userProfile.css">
<style>
</style>
</head>
<body>
<div class="contents" style="height: 800px;">
		<div class="right">
          <ul>
            <li><a class="active" href="#">My Account</a></li>
            <li><a href="${pageContext.request.contextPath}/pages/viewOrder.jsp">My Orders</a></li>
            <li><a href="${pageContext.request.contextPath}/pages/cart.jsp">My Cart</a></li>
            <li><a href="${pageContext.request.contextPath}/LogoutServlet">Log Out</a></li>
          </ul>
        </div>
      <div class="content">
      <h2>Account Information</h2>
      <form action="#">
        <%-- Populate form fields with user details --%>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<%= user.getUsername() %>">
        <label for="email">Username:</label>
        <input type="text" id="username" name="username" value="<%= user.getUsername() %>">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%= user.getEmail() %>">
        <label for="email">Address:</label>
        <input type="text" id="address" name="address" value="<%= user.getAddress() %>">
        <a href="${pageContext.request.contextPath}/pages/editProfile.jsp">Update Profile</a>
      </form>
    </div>
  </div>
</body>


</html>
