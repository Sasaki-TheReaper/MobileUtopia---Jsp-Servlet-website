<%@ page import="Controller.DatabaseController" %>
<%@ page import="model.ProductModel" %>

<%
// Get the product code from the request parameter
String productCode = request.getParameter("code");

// Initialize a ProductModel object to hold the product details
ProductModel product = null;

// Retrieve the product details using the product code
DatabaseController controller = new DatabaseController();
if (productCode != null && !productCode.isEmpty()) {
    product = controller.getProductDetailsByCode(productCode);
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Details</title>
    <style type="text/css">
    body {
  background-color: #f0f0f0; /* Light gray background */
  font-family: Arial, sans-serif;
  margin: 0; /* Remove default body margin */
}

h1 {
  text-align: center;
  color: #2196f3; /* Blue heading */
  font-size: 2em; /* Adjust heading size as needed */
  margin-top: 20px; /* Add some space above the heading */
}

p {
  margin-bottom: 10px;
  line-height: 1.5; /* Adjust line spacing for better readability */
}

.product-details {
  background-color: #fff; /* White product details container */
  padding: 20px;
  border-radius: 5px;
  margin: 20px auto; /* Center the container horizontally */
  max-width: 600px; /* Set a maximum width for responsiveness */
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.1); /* Add subtle shadow */
}

  
    </style>
</head>
 <%@ include file="header.jsp" %>  

<body>
    <h1>Product Details</h1>

    <%-- Check if the product details exist --%>
    <% if (product != null) { %>
        <div style="display: flex;">
        <div>
            <img style="height: 300px;" src="${pageContext.request.contextPath}/images/<%= product.getImage() %>" alt="<%= product.getName() %> Image">
        </div>
        <div style="margin-left: 60px;">
            <h2 style="padding-top: 10px;">Name: <%= product.getName() %></h2>
            <h2 style="padding-top: 10px;">Code: <%= product.getCode() %></h2>
            <h2 style="padding-top: 10px;">Ram: <%= product.getRam() %></h2>
            <h2 style="padding-top: 10px;">Brand: <%= product.getBrand() %></h2>
            <h2 style="padding-top: 10px;">Storage: <%= product.getStorage() %></h2>
            <h2 style="padding-top: 10px;">Camera: <%= product.getCamera() %></h2>
            <h2 style="padding-top: 10px;">Processor: <%= product.getProcessor() %></h2>
            <h2 style="padding-top: 10px;">Price: <%= product.getPrice() %></h2>
            <h2 style="padding-top: 10px;">Battery: <%= product.getBattery() %></h2>
            <h2 style="padding-top: 10px; padding-bottom: 10px;">Description: <%= product.getDescription() %></h2>
        </div>
        <div>
 			 <a href="homepage.jsp" style="background-color: #ddd; padding: 5px 10px; border: 1px solid #ccc; border-radius: 3px; cursor: pointer; text-decoration: none; color: #000; margin-left: 50px;">Back</a>

		</div>

        </div>

        <%-- Form to add the product to the cart --%>
        <form style="margin-top: 20px;" action="../AddToCartServlet" method="post">
            <input type="hidden" name="code" value="<%= product.getCode() %>">
            <label for="quantity" style="padding-left: 100px;">Quantity:</label>
            <input type="number" id="quantity" name="quantity" value="1" min="1" style="padding: 5px 10px; border: 1px solid #ccc; border-radius: 3px; width: 50px; text-align: center;">
            <button type="submit" style="background-color: #2196f3; color: #fff; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer;">Add to Cart</button>
        </form>
        							<form class="col-md-12" action="${pageContext.request.contextPath}/CheckoutServlet" method="post">
										<input type="hidden" name="userEmail" value=<%= session.getAttribute("userEmail") %>>
										<input type="hidden" name="productCode" value=<%= product.getCode() %>> 
										<button type="submit"
										class="btn btn-primary btn-lg py-3 btn-block">Checkout</button>
									</form>
    <% } %>
</body>
 <%@ include file="footer.jsp"%>  

</html>
