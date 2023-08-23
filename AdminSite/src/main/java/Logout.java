import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Logout extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        Cookie[] cookies = request.getCookies();
    	HttpSession session = request.getSession(false);
        
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("user")) {
//                    cookie.setMaxAge(0);
//                    response.addCookie(cookie);
//                    break;
//                }
//            }
//        }
    	if (session != null) {
    		session.invalidate();
    	}
        
        response.sendRedirect("index.jsp");
    }
}