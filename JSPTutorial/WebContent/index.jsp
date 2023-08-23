<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body style="text-align: center;">
		<%@ include file="menuBar.html" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
		
		<!--<div style="visibility: none;">
			<form action="hoc.jsp" method="post">
				<input type="text" name="uname">
				<input type="submit" value="Send Data">
			</form>
		</div>-->
		
		<h2>Reading Data from the Database</h2>
		<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
						   url="jdbc:mysql://localhost:3306/javaDB" 
						   user="saidi" password="blender1"/>
		<sql:query dataSource="${db}" var="rs">
			SELECT * FROM student
		</sql:query>
		<div style="margin-left: 25%; margin-right: auto;">
			<table border="3" width="60%">
				<tr>
					<th>NAME</th>
					<th>EMAIL</th>
					<th>COUNTRY</th>
				</tr>
				<c:forEach var="row" items="${rs.rows }" >
					<tr>
						<td><c:out value="${row.name }"></c:out></td>
						<td><c:out value="${row.email }"></c:out></td>
						<td><c:out value="${row.country }"></c:out></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<br>
		<br>
		<br>
		<br>
		
		<c:out value="Trying out the JSTL core library" />
		<br>
		<c:out value="Successfully launched the JSTL Tag Library" />
		
		<c:set var="Income" scope="session" value="${4000*40000}" />
		<h1><c:out value="The calculated value is ${Income }"></c:out></h1>
		
		<c:remove var="Income" />
		<p><c:out value="After it was removed the value became ${Income }"></c:out></p>
		
		<h2><c:out value="We are going to learn how to catch exceptions in JSTL" /></h2>
		<c:catch var="catchTheException">
			<% int x = 2/0; %>
		</c:catch>
		
		<c:if test="${catchTheException != null}">
			<h4><c:out value="The error that occurred is ${catchTheException }"></c:out></h4>
			<h5><c:out value="The error message is ${catchTheException.message }"></c:out></h5>
		</c:if>
		
		<h3><c:out value="We are going to learn if statements in jstl"></c:out></h3>
		<c:set var="Balance" value="${40000*12 }" />
		<c:if test="${Balance > 10000 }">
			<h4><c:out value="The current balance is ${Balance }"></c:out></h4>
		</c:if>
		
		<h3><c:out value="Choose, When, Otherwise Tags"></c:out></h3>
		<c:set var="income" value="${4000*340 }" />
		<h4><c:out value="The current value of the income is ${income }"></c:out></h4>
		<c:choose>
			<c:when test="${income <= 10000 }">
				<p>Income is not good</p>
			</c:when>
			<c:when test="${income > 10000 }">
				<p>Income is very okay</p>
			</c:when>
			<c:otherwise>
				<p>Can't determine the income information</p>
			</c:otherwise>
		</c:choose>
		
		
		
				
	</body>
</html>