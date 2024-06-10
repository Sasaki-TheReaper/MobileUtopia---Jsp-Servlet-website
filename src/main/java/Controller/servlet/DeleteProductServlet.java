package Controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.DatabaseController;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/DeleteProductServlet" })
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController controllor = new DatabaseController();

    /**
     * Default constructor. 
     */
    public DeleteProductServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Extract product code from request parameter
	        String productCode = request.getParameter("productCode");

	        // Call the removeProduct method to delete the product from the database
	      
	        int result =controllor.removeProduct(productCode);

	        // Set response content type
	        response.setContentType("text/html");

	        // Get PrintWriter object for writing response
	        PrintWriter out = response.getWriter();

	        // Process the result and send response back to the client
	        if (result == 1) {
	            out.println("<h2>Product deleted successfully!</h2>");
	        } else if (result == 0) {
	            out.println("<h2>No product found with the specified code!</h2>");
	        } else {
	            out.println("<h2>Error occurred during database operation!</h2>");
	        }
	    }
	   
	   

}
