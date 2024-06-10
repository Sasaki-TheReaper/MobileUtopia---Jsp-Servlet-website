/*
 * package Controller.servlet;
 * 
 * import java.io.IOException; import java.io.PrintWriter;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import Controller.DatabaseController; import model.UserModel;
 * 
 *//**
	 * Servlet implementation class RegisterServlet
	 */
/*
 * @WebServlet("/RegisterServlet") public class RegisterServlet extends
 * HttpServlet { private static final long serialVersionUID = 1L;
 * DatabaseController controller = new DatabaseController();
 *//**
	 * Default constructor.
	 */
/*
 * public RegisterServlet() { // TODO Auto-generated constructor stub }
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { // TODO Auto-generated
 * method stub
 * response.getWriter().append("Served at: ").append(request.getContextPath());
 * }
 * 
 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // Get parameters from the
		 * request String username = request.getParameter("username"); String address =
		 * request.getParameter("address"); String contact =
		 * request.getParameter("phone"); String email = request.getParameter("email");
		 * String password = request.getParameter("password");
		 * 
		 * // Create a new UserModel object with the received parameters UserModel
		 * userModel = new UserModel(username, address, contact, email, password);
		 * 
		 * // Call the addUser method to register the user in the database int result =
		 * controller.addUser(userModel);
		 * 
		 * // Set response content type response.setContentType("text/html");
		 * 
		 * // Get PrintWriter object for writing response PrintWriter out =
		 * response.getWriter();
		 * 
		 * // Process the result and send response back to the client if (result == 1) {
		 * // User successfully registered
		 * out.println("<h2>User registered successfully!</h2>"); } else if (result ==
		 * -2) { // Username already exists
		 * out.println("<h2>Username already exists!</h2>"); } else if (result == -3) {
		 * // Email already exists out.println("<h2>Email already exists!</h2>"); } else
		 * { // Error occurred during registration
		 * out.println("<h2>Error occurred during registration!</h2>"); } }
		 * 
		 * }
		 */

package Controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.DatabaseController;
import model.UserModel;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DatabaseController controller = new DatabaseController();

    public RegisterServlet() {}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String address = request.getParameter("address");
        String contact = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserModel userModel = new UserModel(username, address, contact, email, password);

        int result = controller.addUser(userModel);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (result == 1) {
            out.println("<h2>User registered successfully!</h2>");
        } else if (result == -2) {
            out.println("<h2>Username already exists!</h2>");
        } else if (result == -3) {
            out.println("<h2>Email already exists!</h2>");
        } else {
            out.println("<h2>Error occurred during registration!</h2>");
        }
    }
}
