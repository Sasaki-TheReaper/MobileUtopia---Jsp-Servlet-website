<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.CartModel" %>
<%@ page import="Controller.DatabaseController" %>
<%@ page import="model.ProductModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/cart.css">
</head>
<body>
<%@ include file="header.jsp"%>

<h1 style="text-align: center;">Cart page</h1>
<div class="site-section">
    <form class="container" method="post" action="checkout">
        <div class="row mb-5">
            <div class="col-md-12">
                <div class="site-blocks-table">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th class="product-thumbnail">Image</th>
                                <th class="product-name">Product</th>
                                <th class="product-price">Price</th>
                                <th class="product-quantity">Quantity</th>
                                <th class="product-total">Total</th>
                                <th class="product-remove">Remove</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            session = request.getSession();
                            String userEmail = (String) session.getAttribute("userEmail");
                            DatabaseController db = new DatabaseController();
                            ArrayList<CartModel> cartItems = db.getCartItems(userEmail);
                            float totalPrice = 0;
                            if (cartItems != null) {
                                for (CartModel cart : cartItems) {
                                    ProductModel product = db.getProductDetailsByCode(cart.getProductCode());
                                    float productTotal = product.getPrice() * cart.getQuantity();
                                    totalPrice += productTotal;
                            %>
                            <tr class="product-row">
                                <td class="product-thumbnail"><img src="<%= product.getImage() %>" alt="Product Image"></td>
                                <td class="product-name"><%= product.getName() %></td>
                                <td class="product-price"><%= product.getPrice() %></td>
                                <td class="product-quantity"><%= cart.getQuantity() %></td>
                                <td class="product-total"><%= productTotal %></td>
                                <td class="product-remove"><a href="${pageContext.request.contextPath}/RemoveFromCart?email=<%= userEmail %>&code=<%= product.getCode() %>" class="btn">Remove</a></td>
                            </tr>
                            <% } %>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- Cart Totals and Checkout Button -->
        <div class="row">
            <div class="col-md-6 offset-md-6">
                <div class="row justify-content-end">
                    <div class="col-md-7">
                        <div class="row">
                            <div class="col-md-12 text-right border-bottom mb-5">
                                <h3 class="text-black h4 text-uppercase">Cart Totals</h3>
                            </div>
                        </div>
                        <div class="row mb-5">
                            <div class="col-md-6">
                                <span class="text-black" style="font-size: 1.5em">Total</span>
                            </div>
                            <div class="col-md-6 text-right">
                                <!-- Display the total price -->
                                <input name="order-price-total" class="form-control-plaintext h5 text-black" value="<%= totalPrice %>" style="text-align: center;" readonly>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <form class="col-md-12" action="${pageContext.request.contextPath}/CheckoutServlet" method="post">
                                    <button type="submit" class="btn btn-primary btn-lg py-3 btn-block">Checkout</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<footer>
    <%@ include file="footer.jsp"%>
</footer>
</body>
</html>
