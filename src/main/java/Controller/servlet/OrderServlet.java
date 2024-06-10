package Controller.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrderModel;
import Controller.DatabaseController;

@WebServlet(asyncSupported = true, urlPatterns = { "/OrderServlet" })
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public OrderServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmail = (String) request.getSession().getAttribute("userEmail");
        DatabaseController dbController = new DatabaseController();
        
        try {
            List<OrderModel> orderHistoryList = dbController.getOrderHistory(userEmail);
            
            request.setAttribute("orderHistoryList", orderHistoryList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewOrder.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error occurred while fetching order history.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewOrder.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
