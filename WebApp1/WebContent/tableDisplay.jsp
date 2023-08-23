<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div>
			<table>
				<%@page import="java.sql.DriverManager"%>
				<%@page import="java.sql.ResultSet"%>
				<%@page import="java.sql.Statement"%>
				<%@page import="java.sql.Connection"%>
				
				<%
				String id = request.getParameter("userId");
				String driverName = "com.mysql.jdbc.Driver";
				String connectionUrl = "jdbc:mysql://localhost:3306/";
				String dbName = "javaDB";
				String userId = "saidi";
				String password = "blender1";
				
				try {
				Class.forName(driverName);
				} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
				
				Connection connection = null;
				Statement statement = null;
				ResultSet resultSet = null;
				%>
				<h2 align="center"><font><strong>Retrieve data from database in jsp</strong></font></h2>
				<table align="center" cellpadding="5" cellspacing="5" border="1">
				<tr>
				
				</tr>
				<tr bgcolor="#A52A2A">
				<td><b>NAME</b></td>
				<td><b>EMAIL</b></td>
				<td><b>AGE</b></td>
				<td><b>DOB</b></td>
				<td><b>GENDER</b></td>
				<td><b>HOBBIES</b></td>
				<td><b>COUNTRY</b></td>
				<td><b>COMMENTS</b></td>
				<td><b>DELETE</b></td>
				<td><b>UPDATE</b></td>
				</tr>
				<%
				try{ 
				connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
				statement=connection.createStatement();
				String sql ="SELECT * FROM student";
				
				resultSet = statement.executeQuery(sql);
				while(resultSet.next()){
				%>
				<tr bgcolor="#DEB887">
				
				<td><%=resultSet.getString(1) %></td>
				<td><%=resultSet.getString(2) %></td>
				<td><%=resultSet.getString(3) %></td>
				<td><%=resultSet.getString(4) %></td>
				<td><%=resultSet.getString(5) %></td>
				<td><%=resultSet.getString(6) %></td>
				<td><%=resultSet.getString(7) %></td>
				<td><%=resultSet.getString(8) %></td>
				<td><a style="text-align: center;" href="DeleteDataServlet?name=<%=resultSet.getString(1)%>">Delete</a></td>
				<td><a style="text-align: center;" href="UpdateServlet?name=<%=resultSet.getString(1)%>">Update</a></td>
				<td><a style="text-align: center;" href="update_form.jsp?name=<%=resultSet.getString(1)%>">Update JSP</a></td>
				</tr>
				<% 
				}
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				%>
				</table>
			</table>
		</div>
	</body>
</html>