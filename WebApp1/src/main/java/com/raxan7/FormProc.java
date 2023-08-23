package com.raxan7;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormProc
 */
@WebServlet("/FormProc")
public class FormProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String dob = request.getParameter("gender");
		String gender = request.getParameter("gender");
		String hobbies = request.getParameter("hobbies");
		String country = request.getParameter("country");
		String comments = request.getParameter("comments");
		response.setContentType("text/html");
		
		String JdbcURL = "jdbc:mysql://localhost:3306/javaDB";
	    String Username = "saidi";
	    String password = "blender1";
		
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(JdbcURL, Username, password);
			
			  
            // Create a SQL query to insert data into demo table
            // demo table consists of two columns, so two '?' is used
            PreparedStatement st = con
                   .prepareStatement("insert into student values(?, ?, ?,?,?,?,?,?)");
  
            // For the first parameter,
            // get the data using request object
            // sets the data to st pointer
  
            // Same for second parameter
            st.setString(1, name);  
            st.setString(2, email);
            st.setString(3, age);
            st.setString(5, dob);
            st.setString(4, gender);
            st.setString(6, hobbies);
            st.setString(7, country);
            st.setString(8, comments);
            
  
            // Execute the insert command using executeUpdate()
            // to make changes in database
            st.executeUpdate();
  
            // Close all the connections
            st.close();
			con.close();
			out.println("<h3>SUCCESSFULLY ENTERED DATA INTO THE DATABASE</h3>");
			out.println("<form><input type='submit' value='Go To View Data From Database'></form>");
			response.sendRedirect("NewServlet");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
		}
		
	}

}
