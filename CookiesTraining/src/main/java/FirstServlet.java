

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("name");
//		Cookie ck = new Cookie("name", uname);
//		response.addCookie(ck);
		HttpSession session = request.getSession();
		session.setAttribute("uname", uname);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2> Hello there " + uname + "</h2>");
		out.println("<form method='post' action='SecondServlet'><input type='submit' value='GO'></form>");
//		doGet(request, response);
	}

}
