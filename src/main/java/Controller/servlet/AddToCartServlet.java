package Controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.DatabaseController;
import model.CartModel;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AddToCartServlet" })
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DatabaseController controller = new DatabaseController();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("userEmail");
        if (userEmail != null) {
            String productCode = request.getParameter("code");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            CartModel cartModel = new CartModel(userEmail, productCode, quantity);

            int result = controller.addToCart(cartModel);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (result == 1) {
                out.println("<h2>Item added to cart successfully!</h2>");
            } else if (result == 0) {
                out.println("<h2>Error occurred while adding item to cart!</h2>");
            } else {
                out.println("<h2>Error occurred during database operation!</h2>");
            }
        } else {
            response.sendRedirect("login.jsp"); // Redirect to login page if user is not logged in
        }
    }
}