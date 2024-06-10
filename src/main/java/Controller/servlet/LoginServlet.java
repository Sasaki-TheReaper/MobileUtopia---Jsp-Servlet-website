
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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DatabaseController controller = new DatabaseController();

    public LoginServlet() {}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        int loginResult = controller.loginUser(email, password);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        if (loginResult == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("userEmail", email);
            
            if (email.equals("admin@admin.com")) {
                response.sendRedirect(request.getContextPath() + "/pages/adminHome.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/pages/homepage.jsp");
            }
        } else if (loginResult == 0) {
            out.println("<h2>Email or password incorrect!</h2>");
        } else {
            out.println("<h2>Error occurred during login!</h2>");
        }
    }
}
