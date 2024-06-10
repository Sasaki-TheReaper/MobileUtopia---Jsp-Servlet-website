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
 * Servlet implementation class FeedbackServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/FeedbackServlet" })
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackServlet() {
        super();
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
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		String phone = request.getParameter("phone");
		
		DatabaseController controller = new DatabaseController();
		int result = controller.saveFeedback(email, message, phone);
		
		response.setContentType("text/html");

        // Get PrintWriter object for writing response
        PrintWriter out = response.getWriter();

        // Process the result and send response back to the client
        if (result == 0) {
            out.println("<h2>Feedback saved.!</h2>");
    
        } else {
            out.println("<h2>Error occurred during database operation!</h2>");
        }

	}

}
