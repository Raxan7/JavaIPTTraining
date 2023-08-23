package com.raxan7;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String request_name = request.getParameter("name");
		PrintWriter out = response.getWriter();
//		out.println(request_name);
		
		response.setContentType("text/html");
		
		String JdbcURL = "jdbc:mysql://localhost:3306/javaDB";
	    String Username = "saidi";
	    String password = "blender1";
		
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(JdbcURL, Username, password);
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student where name = 'Lucha'");
//			request.setAttribute("rs", rs.next());
			while (rs.next()) {
				out.println(rs.getString(1));
				System.out.println(rs.getString(1));
			}

			con.close();
			
			
//			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
		}
	}

}
