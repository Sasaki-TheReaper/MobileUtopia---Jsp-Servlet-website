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
 * Servlet implementation class RemoveFromCart
 */
@WebServlet("/RemoveFromCart")
public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DatabaseController dbController = new DatabaseController(); 

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String productCode = request.getParameter("code");
		System.out.println("email is : " + email + "product code is"+productCode);
		int removeResult = dbController.removeFromCart(email, productCode);
		System.out.println("remove result is : " + removeResult);
		
		PrintWriter out = response.getWriter();
		// yedi result 0 ayo vney delete hunxa 
		if(removeResult == 0) {
			out.println("<h2>Item remived from cart successfully!</h2>");
        } else if (removeResult == 1) {
            out.println("<h2>Error occurred while removing item to cart!</h2>");
        } else {
            out.println("<h2>Error occurred during database operation!</h2>");
        }
		}
		
	}
