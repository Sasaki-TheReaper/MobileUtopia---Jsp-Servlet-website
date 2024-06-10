<%@ page import="java.util.List" %>
<%@ page import="model.ProductModel" %>
<%@ page import="Controller.DatabaseController" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <style type="text/css">
        .search-container {
            display: flex;
            align-items: center;
            justify-content: center;
            margin-top: 20px;
        }

        /* Style the search input */
        #search-input {
            width: 300px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px 0 0 5px;
            font-size: 16px;
        }

        /* Style the search button */
        #search-button {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 0 5px 5px 0;
            cursor: pointer;
            font-size: 16px;
        }

        /* Hover effect for search button */
        #search-button:hover {
            background-color: #0056b3;
        }

        body, html {
            height: 100%;
            width: 100%;
        }

        .gallery {
            padding: 20px;
            width: 300px;
            gap: 20px;
            display: grid;
            grid-template-columns: repeat(4, 1fr);
        }

        .product {
            border: 2px solid black;
            border-radius: 12px;
            padding: 5px;
            background-color: #B9D9EB;
        }
    </style>
    <title>Homepage</title>
</head>
<%@ include file="header.jsp" %>
<body>
<div class="search-container">
    <input type="text" id="search-input" placeholder="Search...">
    <button id="search-button">Search</button>
</div>
<h1 style="font-family: 'Open Sans', sans-serif; font-size: 2em; margin-bottom: 30px; text-align: center;">
    Welcome to Mobile Utopia
</h1>

<%
    DatabaseController dao = new DatabaseController();
    List<ProductModel> productList = dao.viewProducts();
%>

<div class="gallery">
    <%
        if (productList != null && !productList.isEmpty()) {
            for (ProductModel product : productList) {
    %>
                <div class="product">
                    <img style="height: 300px;" src="${pageContext.request.contextPath}/images/<%= product.getImage() %>"
                         alt="<%= product.getName() %> Image">
                    <h1 style="text-align: center;"><%= product.getName() %></h1>
                    <p style="text-align: center;"><%= product.getDescription() %></p>
                    <p style="text-align: center; color: gold;">Price: <%= product.getPrice() %></p>
                    <a href="product.jsp?code=<%= product.getCode() %>">More Details</a>
                    <form style="margin-top: 20px;" action="${pageContext.request.contextPath}/AddToCartServlet" method="post">
                        <input type="hidden" name="code" value="<%= product.getCode() %>">
                        <button type="submit">Add to Cart</button>
                    </form>
                </div>
    <%
            }
        } else {
    %>
            <p>No products found.</p>
    <%
        }
    %>
</div>
</body>
<%@ include file="footer.jsp" %>
</html>
