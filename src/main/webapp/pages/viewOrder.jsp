<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.OrderModel" %>
<%@ page import="Controller.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
</head>
<body>
    <h1>Order History</h1>
    
    <table border="1">
        <tr>
            <th>User Email</th>
            <th>Product Code</th>
            <th>Quantity</th>
            <th>Status</th>
        </tr>
        <% 
            // Fetch order history directly from the database controller
            String userEmail = (String) session.getAttribute("userEmail");
            ArrayList<OrderModel> orderHistoryList = new DatabaseController().getOrderHistory(userEmail);
            
            if (orderHistoryList != null && !orderHistoryList.isEmpty()) {
                for (OrderModel order : orderHistoryList) {
        %>
        <tr>
            <td><%= order.getEmail() %></td>
            <td><%= order.getCode() %></td>
            <td><%= order.getQuantity() %></td>
            <td><%= order.getStatus() %></td>
        </tr>
        <% 
                }
            } else {
        %>
        <tr>
            <td colspan="4">No orders found.</td>
        </tr>
        <% } %>
    </table>
</body>
</html>
