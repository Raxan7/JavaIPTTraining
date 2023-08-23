

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Cookie ck[] = request.getCookies();
		HttpSession session = request.getSession(false);
		String un = (String) session.getAttribute("uname");
		Date date = new Date(session.getCreationTime());
		Date lastAccess = new Date(session.getLastAccessedTime());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	
//		out.println("<h2> Welcome Back " + ck[1].getValue() + "</h2>");
		out.println("<h2> Welcome Back " + un + "</h2>");
		out.println("<h2> SESSION ID " + session.getId() + "</h2>");
		out.println("<h2> CREATED AT " + date + "</h2>");
		out.println("<h2> LAST ACCESSED AT " + lastAccess + "</h2>");
		out.println("<form method='post' action='SecondServlet'><input type='submit' value='GO'></form>");
//		doGet(request, response);
	}

}
// Login
//Profile
//Logout
