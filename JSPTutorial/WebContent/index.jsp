<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%@ include file="menuBar.html" %>
		<form action="hoc.jsp" method="post">
			<input type="text" name="uname">
			<input type="submit" value="Send Data">
		</form>
	</body>
</html>