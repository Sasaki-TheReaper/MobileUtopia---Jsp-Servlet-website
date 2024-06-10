package Controller.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList; // Import ArrayList
import Controller.DatabaseController;
import model.ProductModel;

@WebServlet("/ProductSearchServlet")
public class ProductSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");

        DatabaseController controller = new DatabaseController(); 
        ArrayList<ProductModel> productList = controller.searchProductsByName(productName); // Use ArrayList instead of List

        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }
}
