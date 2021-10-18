<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
<h1>Create New List </h1>
	<form action="createNewListServlet" method="post">
		List Name: <input type="text" name="listName"><br /> Death
		date: <input type="text" name="month" placeholder="mm" size="4">
		<input type="text" name="day" placeholder="dd" size="4">, <input
			type="text" name="year" placeholder="yyyy" size="4"> Game
		Name: <input type="text" name="gameName"><br /> Current
		Players: <br /> <select name="allPlayersToAdd" multiple size="6">
			<c:forEach items="${requestScope.allPlayers}" var="currentplayer">
				<option value="${currentplayer.id}">${currentplayer.playerName}
					| ${currentplayer.gender}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create List and Add Players">
	</form>
	<a href="index.html">Go add new players instead.</a>
</body>
</html>