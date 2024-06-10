<%@ page import="Controller.DatabaseController" %>
<%@ page import="model.ProductModel" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Products</title>
    <style>
    /* CSS for product display */
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

h1 {
    text-align: center;
    margin-top: 20px;
}

div {
    border: 1px solid #ccc;
    border-radius: 5px;
    padding: 10px;
    margin-bottom: 20px;
}

p {
    margin: 5px 0;
}

button {
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    padding: 5px 10px;
    cursor: pointer;
    margin-right: 5px;
}

button:hover {
    background-color: #0056b3;
}

a {
    display: block;
    text-align: center;
    margin-top: 20px;
    text-decoration: none;
    color: #007bff;
}

a:hover {
    text-decoration: underline;
}
    
    </style>
</head>
<body>
    <h1>View Products</h1>
    
    <% 
        DatabaseController controller = new DatabaseController();
        List<ProductModel> productList = controller.viewProducts();
        
        
        // Check if the product list is not empty
        if (productList != null && !productList.isEmpty()) {
            // Iterate over each product
            for (ProductModel product : productList) {
    %>
                <div>
                    <!-- Display product properties -->
                    <p>Image: <%= product.getImage() %></p>
                    <p>Name: <%= product.getName() %></p>
                    <p>Code: <%= product.getCode() %></p>
                    <p>Ram: <%= product.getRam() %></p>
                    <p>Brand: <%= product.getBrand() %></p>
                    <p>Storage: <%= product.getStorage() %></p>
                    <p>Camera: <%= product.getCamera() %></p>
                    <p>Processor: <%= product.getProcessor() %></p>
                    <p>Price: <%= product.getPrice() %></p>
                    <p>Battery: <%= product.getBattery() %></p>
                    <p>Description: <%= product.getDescription() %></p>
                    
                    <!-- Add buttons for edit and remove -->
                    <form action="edit_product.jsp" method="post">
                        <input type="hidden" name="code" value="<%= product.getCode() %>">
                        <button type="submit">Edit</button>
                    </form>
                    
                    <form action="../DeleteProductServlet" method="post">
                        <input type="hidden" name="productCode" value="<%= product.getCode() %>">
                        <button type="submit">Remove</button>
                       
                    </form>
                </div>
                <hr>
    <%
            }
        } else {
    %>
            <p>No products found.</p>
    <% 
        }
    %>
    
    <!-- Link to add product page -->
    <a href="AddProduct.jsp">Add Product</a>
</body>
</html>
