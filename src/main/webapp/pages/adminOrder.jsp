<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.OrderModel" %>
<%@ page import="Controller.DatabaseController" %>
<%@ page import="java.sql.SQLException" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Orders</title>
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/stylesheet/adminOrder.css">
</head>
<body>
    <h1 style="text-align: center;">Admin Orders</h1>
    <div class="site-section">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Email</th>
                    <th>Product Code</th>
                    <th>Quantity</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                DatabaseController db = new DatabaseController();
                ArrayList<OrderModel> orders = db.getAllOrders();
                if (orders != null) {
                    for (OrderModel order : orders) {
                %>
                <tr>
                    <td><%= order.getEmail() %></td>
                    <td><%= order.getCode() %></td>
                    <td><%= order.getQuantity() %></td>
                    <td>
                        <select>
                            <option value="pending" <%= order.getStatus().equals("pending") ? "selected" : "" %>>Pending</option>
                            <option value="delivered" <%= order.getStatus().equals("delivered") ? "selected" : "" %>>Delivered</option>
                        </select>
                    </td>
                    <td><button>Update</button></td>
                </tr>
                <% } %>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
