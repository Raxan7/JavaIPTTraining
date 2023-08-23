<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="styles.css">
	</head>
	<body>
		<div class="form-div">
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
			<h2 align="center"><font><strong>Edit your Data</strong></font></h2>
			<%
			String name = request.getParameter("name");
			try{ 
			connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
			statement=connection.createStatement();
			String sql ="SELECT * FROM student where name = '" + name + "'";
			
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
			%>
				<form action="FormProc" method="post">
				    <label for="name">Name:</label>
				    <input type="text" id="name" name="name" value=<%= resultSet.getString(1) %> required><br>
				    
				    <label for="email">Email:</label>
				    <input type="email" id="email" name="email" value=<%= resultSet.getString(2) %> required><br>
				    
				    <label for="age">Age:</label>
				    <input type="number" id="age" name="age" value=<%= resultSet.getString(3) %>><br>
				    
				    <label for="dob">Date of Birth:</label>
				    <input type="date" id="dob" name="dob" value=<%= resultSet.getString(4) %>><br>
				    
				    if (resultSet.getString(5).isequal("male")){
				    	<label>Gender:</label>
					    <input type="radio" id="male" name="gender" value="male" checked>
					    <label for="male">Male</label>
					    <input type="radio" id="female" name="gender" value="female">
					    <label for="female">Female</label><br>
				    } else {
				    	<label>Gender:</label>
					    <input type="radio" id="male" name="gender" value="male">
					    <label for="male">Male</label>
					    <input type="radio" id="female" name="gender" value="female" checked>
					    <label for="female">Female</label><br>
				    }
				    
				    <label>Hobbies:</label>
				    <input type="checkbox" id="reading" name="hobbies" value="reading">
				    <label for="reading">Reading</label>
				    <input type="checkbox" id="traveling" name="hobbies" value="traveling">
				    <label for="traveling">Traveling</label><br>
				    
				    <label for="country">Country:</label>
				    <select id="country" name="country">
				        <option value="tanzania">Tanzania</option>
				        <option value="kenya">Kenya</option>
				        <option value="uganda">Uganda</option>
				    </select><br>
				    
				    <label for="comments">Comments:</label>
				    <textarea id="comments" name="comments" rows="4" cols="50"></textarea><br>
				    
				    <label for="profile">Upload Profile Picture:</label>
				    <input type="file" id="profile" name="profile"><br>
				    
				    <input type="submit" value="Submit">
				    <input type="reset" value="Reset">
				</form>
			<% 
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			%>
		</div>
	</body>
</html>