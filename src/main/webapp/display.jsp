<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Record</title>
</head>
<body>
	<c:choose>
		<c:when test="${student ne null || !empty student}">
			<table border="1" align="center">
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>AGE</th>
					<th>ADDRESS</th>
				</tr>
				
				<tr>
					<td>${student.sid}</td>
					<td>${student.sname}</td>
					<td>${student.sage}</td>
					<td>${student.saddress}</td>
				</tr>
				
			</table>
		</c:when>
		
		<c:otherwise>
			<h1 style='color: red; text-align: center'>No Record To Display</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>