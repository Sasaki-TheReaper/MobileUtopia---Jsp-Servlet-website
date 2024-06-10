package Controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import Controller.DatabaseController;
import model.UserModel;


@WebServlet(asyncSupported = true, urlPatterns = { "/UpdateProfileServlet" })
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateProfileServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
	  	String userEmail = (String) session.getAttribute("userEmail");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String password = request.getParameter("password");
		
		UserModel user = new UserModel(username, address, contact, email, password);
		
		DatabaseController db = new DatabaseController();
		int loginResult = db.updateUser(user, userEmail);
		PrintWriter out = response.getWriter();
		
		if (loginResult == 1) {
			 out.println("<h2>Updated</h2>");
//	       
	    	
	    } else if (loginResult == 0) {
	        out.println("<h2>Updated!</h2>");
	    } else {
	        out.println("<h2>Error occurred during login!</h2>");
	    }
		
	}

}
