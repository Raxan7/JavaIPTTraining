import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Profile extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        Cookie[] cookies = request.getCookies();
    	HttpSession session = request.getSession(false);
    	String name = (String) session.getAttribute("username");
        boolean loggedIn = false;
        
        if (session != null) {
            loggedIn = true;
        }
        
        PrintWriter out = response.getWriter();
        
        if (loggedIn) {
//            String username = cookies[1].getValue(); // Set the username here
            response.setContentType("text/html");
            out.println("<html><body>");
            out.println("<h2>Welcome, " + name + "!</h2>");
            out.println("<form method='get' action='Logout'><input type='submit' value='LOGOUT'></form>");
            out.println("</body></html>");
        } else {
        	response.setContentType("text/html");
            out.println("<html><body>");
            out.println("<h2>You are not logged in.</h2>");
            out.println("</body></html>");
        }
    }
}