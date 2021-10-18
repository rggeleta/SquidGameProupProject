<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit An Existing List</title>
</head>
<body>
	<form action="editListDetailsServlet" method="post">
	<h1>Edit An Existing List</h1>
		<input type="hidden" name="id" value="${listToEdit.id}"> List
		Name: <input type="text" name="listName"
			value="${listToEdit.listName}"><br /> Death date: <input
			type="text" name="month" placeholder="mm" size="4" value="${month}">
		<input type="text" name="day" placeholder="dd" size="4"
			value="${date}">, <input type="text" name="year"
			placeholder="yyyy" size="4" value="${year}"> Game Name: <input
			type="text" name="gameName" value="${listToEdit.game.gameName}"><br />
		Current Players:<br /> <select name="allPlayersToAdd" multiple
			size="6">
			<c:forEach items="${requestScope.allPlayers}" var="currentplayer">
				<option value="${currentplayer.id}">${currentplayer.playerName}
					| ${currentplayer.gender}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Edit List and Add Players">
	</form>
	<br>
	<a href="index.html">Go add new players instead.</a>
</body>
</html>