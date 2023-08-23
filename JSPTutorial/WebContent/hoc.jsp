<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			body {
				background-color: silver;
			}
		</style>
	</head>
	<body>
		<% 
			String name = request.getParameter("uname");
			out.println("The name entered is " + name);
		%>
	</body>
</html>