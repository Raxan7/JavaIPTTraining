import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	String username = request.getParameter("name");      
    	String password = request.getParameter("password");
    	System.out.println(password.equals("1234"));
        
        if (password.equals("1234")) {
//            Cookie cookie = new Cookie("user", username);
//            response.addCookie(cookie);
        	HttpSession session = request.getSession();
        	session.setAttribute("username", username);
            response.sendRedirect("Profile");
        } else {
            out.println("<h2>Wrong password</h2>");
        }
    }
}