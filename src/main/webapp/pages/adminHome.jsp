<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Mobile Utopia Admin Dashboard</title>
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

    
  </style>
</head>
<body>
  <div id="div1">
    <img class="img1" src="logo.jpg">
    <h1 id="h1">Mobile Utopia</h1>
    <a href="${pageContext.request.contextPath }/LogoutServlet"><h3 id="h2">Logout</h3></a>
  </div>
  <div id="div2">
    <h3>Admin Dashboard</h3>
    <ul>  <li><a href="${pageContext.request.contextPath}/pages/add_product.jsp">Add Product</a></li>
      <li><a href="${pageContext.request.contextPath}/pages/view_product.jsp">View Product</a></li>
      <li><a href="${pageContext.request.contextPath}/pages/viewOrder.jsp">Order</a></li>
    </ul>
  </div>
</body>
</html>
