<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
   	<style>
    body {
      background-color: rgb(220, 225, 229);
    }

    #div1 {
      display: flex;
      background-color: rgb(27, 106, 243);
      height: 70px;
      align-items: center;  }

    #div1 #h1 {
      padding-left: 20px;  color: white;
      font-size: 24px;     }

    #div1 #h2 {
      padding: 10px 20px;   margin-left: 1000px;    color: white;
    }

    
    #div2 {
  background-color: white;
  border: 1px solid #ccc;
  padding: 10px;
  width: 200px;
  height: 500px;
}

#div2 h3 {
  font-size: 25px;
  margin-bottom: 25px;
}

#div2 ul {
  list-style-type: none;
  padding: 0;
  margin: 10px;
}

#div2 ul li {
  margin-bottom: 25px;
}

#div2 ul li a {
  text-decoration: none;
  color: #333;
  font-size: 20px;
}

#div2 ul li a:hover {
  color: #0066cc;
}
.img1 {
  height: 70px;
  width: 70px;
}

.big{
display: flex;
}

 .row {
            margin-bottom: 10px;
        }

        .col {
            margin-bottom: 10px;
        }

        label {
            font-weight: bold;
        }

        input[type="text"],
        input[type="number"],
        input[type="file"],
        button[type="submit"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        /* Additional styling for file input */
        #imageLabel {
            margin-top: 5px;
        }

        #image-input {
            margin-top: 5px;
        }

        /* Responsive styling */
        @media (max-width: 768px) {
            .col {
                flex: 0 0 100%;
                margin-right: 0;
            }
        }

    
  </style>																																																												
</head>
<body>
  <div id="div1">
    <img class="img1" src="logo.jpg">
    <h1 id="h1">Mobile Utopia</h1>
    <a href="${pageContext.request.contextPath }/LogoutServlet"><h3 id="h2">Logout</h3></a>
  </div>
  <div class="big">
  <div id="div2">
    <h3>Admin Dashboard</h3>
    <ul>  <li><a href="${pageContext.request.contextPath}/pages/adminHome.jsp">Add Product</a></li>
      <li><a href="${pageContext.request.contextPath}/pages/view_product.jsp">View Product</a></li>
      <li><a href="${pageContext.request.contextPath}/pages/viewOrder.jsp">Order</a></li>
    </ul>
  </div>
    <div id="div4" style="margin-left: 300px;">
       <h2>Add new Smartphone</h2>

<form action="../AddProductServlet" method="post" enctype="multipart/form-data">
	<div style="display: flex;">
  <div>
  <div class="row">
    <div class="col">
      <label for="name" id="nameLabel">Model:</label>
      <input type="text" id="name" name="name" required>
    </div>
    <div class="col">
      <label for="price" id="priceLabel">Price:</label>
      <input type="text" id="price" name="price" required>
    </div>
      <div class="col">
      <label for="code" id="codeLabel">Code:</label>
      <input type="text" id="code" name="code" required>
    </div>
    <div class="col">
      <label for="description" id="descriptionLabel">Description:</label>
      <input type="text" id="description" name="description" required>
    </div>
  </div>
  
  <div class="row">
    <div class="col">
      <label for="stock" id="stockLabel">Quantity:</label>
      <input type="text" id="stock" name="stock" required>
    </div>
    <div class="col">
      <label for="brand" id="brandLabel">Brand:</label>
      <input type="text" id="brand" name="brand" required>
    </div>
    <div class="col">
      <label for="ram" id="ramLabel">RAM:</label>
      <input type="text" id="ram" name="ram" required>
    </div>
    <div class="col">
      <label for="camera" id="cameraLabel">Camera:</label>
      <input type="text" id="camera" name="camera" required>
    </div>
  </div>
  </div>
  <div>
 	<div class="row">
    <div class="col">
      <label for="storage" id="storageLabel">Storage:</label>
      <input type="text" id="storage" name="storage" required>
    </div>
      <div class="col">
      <label for="processor" id="processorLabel">Processor:</label>
      <input type="text" id="processor" name="processor" required>
    </div>
    <div class="col">
      <label for="battery" id="batteryLabel">Battery:</label>
      <input type="text" id="battery" name="battery" required>
    </div>
    <div class="col">
      <label for="image-input" id="imageLabel">Product Image:</label>
      <input type="file" id="image-input" name="productImage" accept="image/*" required>
    </div>
    <div class="col">
      <button type="submit" id="submitButton">Add Product</button>
    </div>
  </div>
  </div>
  </div>
  </div>
</form>
    </div>
</body>
</html>