

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class DBConnection
 */
@WebServlet("/DBConnection")
public class DBConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		PrintWriter out = response.getWriter();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		out.println();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String JdbcURL = "jdbc:mysql://localhost:3306/javaDB";
		    String Username = "saidi";
		    String password = "blender1";
			
			Connection con = DriverManager.getConnection(JdbcURL, Username, password);
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			
			while (rs.next()) {
				out.println(rs.getInt(1) + " " + rs.getString(2));
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Ooops something went wrong!");
			e.printStackTrace();
		}
	}
}
