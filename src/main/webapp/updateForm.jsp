<%@ page language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
</head>
<body>
	<br/>
	<br/>
	<c:choose>
		<c:when test="${student ne null || !empty student}">
		
			<form action="./controller/updateRecord" method="get">
				<table border="1" align='center'>
					<tr>
						<th>SID</th>
						<td>
							<input type="text" readonly="readonly" name='sid' value="${student.sid}"/>
						</td>
					</tr>
						
					<tr>
						<th>SNAME</th>
						<td>
							<input type="text" name="sname" value="${student.sname}"/>
						</td>
					</tr>
					
					<tr>
						<th>SAGE</th>
						<td>
							<input type="text" name="sage" value="${student.sage}"/>
						</td>
					</tr>
					
					<tr>
						<th>SADDRESS</th>
						<td>
							<input type="text" name="saddr" value="${student.saddress}"/>
						</td>
					</tr>
											
					<tr>
						<th></th>
						<td>
							<input type="submit" value="Update"/>
						</td>
					</tr>
				</table>
			</form>
						
		</c:when>
		
		<c:otherwise>
			<h1 style="color: red; text-align: center;">No Record to Display</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>