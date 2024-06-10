<%@ page import="model.ProductModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
</head>
<body>
    <h2>Search Results</h2>
    
    <%  // Java code starts here
        // Retrieve the productList from the request attribute
        ArrayList<ProductModel> productList = (ArrayList<ProductModel>) request.getAttribute("productList");
        
        // Check if the productList is not empty
        if (productList != null && !productList.isEmpty()) {
            // Iterate over each product in the productList
            for (ProductModel product : productList) {
    %>
                <div>
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
                    <hr>
                </div>
    <%          } // End of for loop
        } else { // If productList is empty or null
    %>
            <p>No products found.</p>
    <%  } // End of if-else block
    %>
</body>
</html>
