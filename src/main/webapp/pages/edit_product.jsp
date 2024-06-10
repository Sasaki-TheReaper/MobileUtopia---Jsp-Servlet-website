<%@ page import="model.ProductModel"%>
<%@ page import="java.util.List"%>
<%@ page import="Controller.DatabaseController"%>

<%-- Retrieve the product code from the request --%>
<%
String productCode = request.getParameter("code");
%>

<%-- Get the product details using the product code --%>
<%
ProductModel product = null;
DatabaseController controller = new DatabaseController();
if (productCode != null && !productCode.isEmpty()) {
	// Call the method to retrieve the product details by code
	product = controller.getProductDetailsByCode(productCode);
}
%>

<%-- Check if the product exists --%>
<%
if (product != null) {
%>
<style>
/* CSS for form layout */
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f4f4;
}

form {
    max-width: 600px;
    margin: 20px auto;
    background-color: #fff;
    padding: 20px;
    border-radius: 5px;
    border: 1px solid #ccc;
}

label {
    display: block;
    margin-bottom: 5px;
}

input[type="text"],
input[type="number"] {
    width: calc(100% - 10px); /* Adjust for input padding */
    padding: 8px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

button[type="submit"] {
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

button[type="submit"]:hover {
    background-color: #0056b3;
}

p {
    margin-top: 20px;
    text-align: center;
    font-style: italic;
}

</style>
<form action="../EditProductServlet" method="post">
    <input type="hidden" name="code" value="<%=product.getCode()%>">

    <label for="name">Name:"<%=product.getCode()%>"</label> <input type="text" id="name" name="name"> <br>
    <label for="ram">Ram:</label> <input type="text" id="ram" name="ram"> <br>
    <label for="brand">Brand:</label> <input type="text" id="brand" name="brand"> <br>
    <label for="storage">Storage:</label> <input type="text" id="storage" name="storage"> <br>
    <label for="camera">Camera:</label> <input type="text" id="camera" name="camera"> <br>
    <label for="processor">Processor:</label> <input type="text" id="processor" name="processor"> <br>
    <label for="price">Price:</label> <input type="number" id="price" name="price"> <br>
    <label for="battery">Battery:</label> <input type="text" id="battery" name="battery"> <br>
    <label for="description">Description:</label> <input type="text" id="description" name="description"> <br>
	<label for="stock">Stock:</label> <input type="number" id="stock" name="stock"> <br>
    <!-- Add update button -->
    <button type="submit">Update</button>
</form>
<%
} else {
%>
<p>No product found.</p>
<%
}
%>
