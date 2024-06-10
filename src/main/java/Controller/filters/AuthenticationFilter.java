/*
 * package Controller.filters;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.Filter; import javax.servlet.FilterChain; import
 * javax.servlet.FilterConfig; import javax.servlet.ServletException; import
 * javax.servlet.ServletRequest; import javax.servlet.ServletResponse; import
 * javax.servlet.annotation.WebFilter; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * @WebFilter("/*") public class AuthenticationFilter implements Filter {
 * 
 * @Override public void destroy() { // TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public void doFilter(ServletRequest request, ServletResponse
 * response, FilterChain chain) throws IOException, ServletException {
 * HttpServletRequest req = (HttpServletRequest) request; HttpServletResponse
 * res = (HttpServletResponse) response;
 * 
 * String uri = req.getRequestURI();
 * 
 * boolean isLoginPage = uri.endsWith("login.jsp") ||
 * uri.endsWith("LoginServlet"); boolean isLoggedIn =
 * req.getSession().getAttribute("username") != null;
 * 
 * // Allow access to login and registration pages for both logged-in and not
 * logged-in users if (isLoginPage) { chain.doFilter(request, response); return;
 * }
 * 
 * // Redirect not logged-in users to the login page for protected pages if
 * (!isLoggedIn && !uri.endsWith("register.jsp") &&
 * !uri.endsWith("RegisterServlet")) { res.sendRedirect(req.getContextPath() +
 * "/pages/login.jsp"); return; }
 * 
 * // Allow access to all other pages for both logged-in and not logged-in users
 * chain.doFilter(request, response); }
 * 
 * @Override public void init(FilterConfig arg0) throws ServletException { //
 * TODO Auto-generated method stub
 * 
 * }
 * 
 * }
 */

package Controller.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String uri = req.getRequestURI();   
        
        HttpSession session = req.getSession(false);
        boolean isLoggedIn = session != null && session.getAttribute("userEmail") != null;
        
        if (uri.endsWith("login.jsp") || uri.endsWith("LoginServlet") || uri.endsWith("RegisterServlet")) {
            chain.doFilter(request, response);
            return;
        }
        
        if (uri.endsWith(".css") || uri.endsWith("LoginServlet") || uri.endsWith("RegisterServlet")) {
            chain.doFilter(request, response);
            return;
        }
        
        if (isLoggedIn || uri.endsWith("homepage.jsp") || uri.endsWith("AddToCartServlet")) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() + "/pages/login.jsp");
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {}
}
