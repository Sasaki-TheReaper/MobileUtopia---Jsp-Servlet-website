<%@ page import="java.util.List" %>
<%@ page import="model.ProductModel" %>
<%@ page import="Controller.DatabaseController" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	body,html{
	height:100%;
	width: 100%;
	}
	
	.gallery{
	padding: 20px;
	width: 300px;
	gap: 20px;
	display: grid;
	grid-template-columns: repeat(4, 1fr);
	
	}
	
	.product{
	border: 2px solid black;
	border-radius: 12px;
	padding: 5px;
	background-color: #B9D9EB;
	}
	
</style>
</head>
<body>
<%@ include file="header.jsp" %>
<body>
    <h1 style="text-align: center; padding-top: 40px;">Our Products</h1>
    <h4 style="text-align: center; padding: 5px;">Get quality products on reasonable price.</h4>
    
    <%-- Retrieve the list of products --%>
    
    <%
        DatabaseController dao = new DatabaseController(); // Replace YourDAOClass with the actual name of your DAO class
        List<ProductModel> productList = dao.viewProducts(); // Assuming this method returns the list of products
    %>
    
    <%-- Iterate over the list of products and display each product --%>
    <div class="gallery">
    <%
        for(ProductModel product : productList) {
    %>
            <div class="product">
            	<img style="height: 300px;" src="${pageContext.request.contextPath}/images/<%= product.getImage() %>" alt="<%= product.getName() %> Image">
                <h1 style="text-align: center;"><%= product.getName() %></h1>
                <p style="text-align: center;"><%= product.getDescription() %></p>
                <p style="text-align: center;">Price: <%= product.getPrice() %></p>
				<a href="product.jsp?code=<%= product.getCode() %>">More Details</a>
                <%-- Add more product details as needed --%>
            </div>
    <%
        }
    %>
    </div>
</body>
<%@ include file="footer.jsp" %>
</body>
</html>