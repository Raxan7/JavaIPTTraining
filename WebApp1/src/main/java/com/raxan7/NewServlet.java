package com.raxan7;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Display the data t the user from the database
		String destination = "tableDisplay.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		String JdbcURL = "jdbc:mysql://localhost:3306/javaDB";
	    String Username = "saidi";
	    String password = "blender1";
		
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(JdbcURL, Username, password);
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			request.setAttribute("rs", rs.next());

			while (rs.next()) {
//				out.println("<h3>NAME - " + rs.getString(1) + "</h3>");
//				out.println("<h3>EMAIL - " + rs.getString(2) + "</h3>");
//				out.println("<h3>AGE - " + rs.getString(3) + "</h3>");
//				out.println("<h3>DATE OF BIRTH - " + rs.getString(4) + "</h3>");
//				out.println("<h3>GENDER - " + rs.getString(5) + "</h3>");
//				out.println("<h3>HOBBIES - " + rs.getString(6) + "</h3>");
//				out.println("<h3>COUNTRY - " + rs.getString(7) + "</h3>");
//				out.println("<h3>COMMENTS - " + rs.getString(8) + "</h3>");
//				out.println("<br>");
//				out.println("<br>");
				}
			con.close();
			
			
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
		}
	}

}
