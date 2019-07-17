<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>users currently in the shop</title>
</head>

<body>
	<h1>Current Users</h1>
	<table>
		<thead>
			<td>User Id</td>
			<td>User Name</td>
			<td>Email</td>
			<td>Dorm Number</td>
			<td>Room Number</td>
			<td>Address</td>
			<td></td>
		</thead>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.uid}</td>
				<td>${user.userName}</td>
				<td>${user.email}</td>
				<td>${user.addr.dormNumber}</td>
				<td>${user.addr.roomNumber}</td>
				<td>${user.addr.address}</td>
				<td><a href="users/${user.id}">edit</a></td>
			</tr>
		</c:forEach>
	</table>

	<sec:authorize access="hasRole('ADMIN')">
		<a href="users/add"> Add a user</a>
	</sec:authorize>
	<a href="logout">Logout</a>
</body>

</html>