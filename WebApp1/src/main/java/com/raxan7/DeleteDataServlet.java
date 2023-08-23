package com.raxan7;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteDataServlet
 */
@WebServlet("/DeleteDataServlet")
public class DeleteDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("name");
		System.out.println(name);
		
		 int rows;
		   response.setContentType("text/html");
		   PrintWriter pw = response.getWriter();
		   String connectionURL = "jdbc:mysql://localhost:3306/javaDB";
		   Connection connection;
		   try{
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   connection = DriverManager.getConnection(connectionURL, "saidi", "blender1");
			   PreparedStatement pst = connection.prepareStatement("delete from student where name = '" + name + "'");
			   int i = pst.executeUpdate();
			   if (i==0){
				   pw.println("Row has been deleted");
			   }
			   else{
				   pw.println("No rows has been deleted");
			   }
			   response.sendRedirect("tableDisplay.jsp");	   }
		   catch(Exception e){
			   pw.println("The exception is " + e);
		   }
	}
}
