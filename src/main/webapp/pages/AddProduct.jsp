<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../style/addProduct.css">
</head>
<body>
    <div id="div1">
        <p> Logo </p>
        <h1 id="h1">Mobile Utopia</h1>
        <h3 id="h2">Log out</h3>
	</div>
    <div id="div3">
    <div id="div2">
        <h2>Mobile Utopia</h2>
        <ol><button href="/admin.html">Dashboard</button></ol>
        <ol><button>View product</button></ol>
        <ol><button>Order</button></ol>
    </div>
    <div id="div4">
        <button id="b11">Back</button>
        <h2>Add new Smartphone</h2>
<form action="../AddProductServlet" method="post"  enctype="multipart/form-data">
  <div class="row">
    <div class="col">
      <label for="name" id="nameLabel">Model:</label>
      <input type="text" id="name" name="name" required>
    </div>
    <div class="col">
      <label for="price" id="priceLabel">Price:</label>
      <input type="text" id="price" name="price" required>
    </div>
  </div>
  
      <div class="col">
      <label for="code" id="codeLabel">Code:</label>
      <input type="text" id="code" name="code" required>
    </div>
  </div>
  
  <div class="row">
    <div class="col">
      <label for="description" id="descriptionLabel">Description:</label>
      <input type="text" id="description" name="description" required>
    </div>
    <div class="col">
      <label for="stock" id="stockLabel">Quantity:</label>
      <input type="text" id="stock" name="stock" required>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <label for="brand" id="brandLabel">Brand:</label>
      <input type="text" id="brand" name="brand" required>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <label for="ram" id="ramLabel">RAM:</label>
      <input type="text" id="ram" name="ram" required>
    </div>
    <div class="col">
      <label for="camera" id="cameraLabel">Camera:</label>
      <input type="text" id="camera" name="camera" required>
    </div>
  </div>
 
    <div class="col">
      <label for="storage" id="storageLabel">Storage:</label>
      <input type="text" id="storage" name="storage" required>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <label for="processor" id="processorLabel">Processor:</label>
      <input type="text" id="processor" name="processor" required>
    </div>
    <div class="col">
      <label for="battery" id="batteryLabel">Battery:</label>
      <input type="text" id="battery" name="battery" required>
    </div>
  </div>
 
  <div class="row">
    <div class="col">
      <label for="image-input" id="imageLabel">Product Image:</label>
      <input type="file" id="image-input" name="productImage" accept="image/*" required>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <button type="submit" id="submitButton">Add Product</button>
    </div>
  </div>
</form>
    </div>
    </div>
</body>
</html>