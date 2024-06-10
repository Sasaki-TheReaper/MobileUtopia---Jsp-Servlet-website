<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Header</title>
    <%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/header.css"> --%>
    <style type="text/css">
    *{
    padding:0;
    margin:0;
    text-decoration: none;
    list-style: none;
    box-sizing: border-box;
}
body{
    font-family:montserrat;
}
nav{
    background: #1C62BB;
    height: 80px;
    width: 100vw;
}
label.logo{
    color: white;
    font-size: 35px;
    line-height: 80px;
    padding: 0 100px;
    font-weight: bold;
}
nav ul{
    float:right;
    margin-right: 20px;
}
nav ul li{
    display: inline-block;
    line-height: 80px;
    margin: 0 5px;
}
nav ul li a{
    color: white;
    font-size: 17px;
    padding: 7px 13px;
    border-radius: 3px;
    text-transform: uppercase;
}
a:hover{
    background: #1b9bff;
    transition: .5s;
}
  .contents {
    display: flex;
  }
    
    </style>
</head>
<body>


<div class="contents">
    <nav>
        <label class="logo">Mobile Utopia</label>
        <ul>
            <li><a href="${pageContext.request.contextPath}/pages/homepage.jsp">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/pages/userproductview.jsp">Product</a></li>
            <li><a href="${pageContext.request.contextPath}/pages/cart.jsp">Cart</a></li>
            <li><a href="${pageContext.request.contextPath}/pages/contact.jsp">Contact</a></li>
            
            <% 
               // Check if the user is logged in
               String email = (String) session.getAttribute("userEmail");
               if(email == null) { // If not logged in, display Login link
            %>
                   <li><a href="${pageContext.request.contextPath}/pages/login.jsp">Login</a></li>
            <% 
               } else { // If logged in, display Logout and My profile links
            %>
                   <li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>
                   <li><a class="active" href="${pageContext.request.contextPath}/pages/userProfile.jsp">My profile</a></li>
            <% 
               } 
            %>
        </ul>
    </nav>
</div>
</body>

</html>