<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Players</title>
</head>
<body>
	<h1>View All Players</h1>
	<form method = "post" action = "navigationServlet">
	
	
		<table>
			<c:forEach items="${requestScope.allPlayers}" var="currentplayer">
				<tr>
					<td><input type="radio" name="id" value="${currentplayer.id}"></td>
					<td>${currentplayer.playerName}</td>
					<td>${currentplayer.gender}</td>
				</tr>
			</c:forEach>
		</table>
		
		<input type = "submit" value = "edit" name="doThisToPlayer">
		<input type = "submit" value = "delete" name="doThisToPlayer">
		<input type="submit" value = "add" name = "doThisToPlayer">
	</form>
	<br>
		<a href="new-list.jsp">Create a new List</a><br><br>
	<a href="index.html">Insert a new player</a>
</body>
</html>