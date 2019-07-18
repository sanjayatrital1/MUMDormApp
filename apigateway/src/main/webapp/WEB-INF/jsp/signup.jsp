<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="index.jsp" />

<div class="container">
	<h1>New SignUp</h1>
	<form:form modelAttribute="user" action="/users/create" method="post">
		<table>
			<div class="form-group">
				<tr>
					<td class="col-sm-3 control-label">Username*</td>
					<div class="col-sm-9">
						<td><form:input path="userName" /></td>
						<td><form:errors path="userName" /></td>
					</div>
				</tr>
			</div>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
				<td>${msg}<form:errors path="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>
            <tr>
                <td>Address</td>
                <td><form:input path="addr.address" /></td>
                <td><form:errors path="addr.address" /></td>
            </tr>
            <tr>
                <td>Dorm Number</td>
                <td><form:input path="addr.dormNumber" /></td>
                <td><form:errors path="addr.dormNumber" /></td>
            </tr>
            <tr>
                <td>Room Number</td>
                <td><form:input path="addr.roomNumber" /></td>
                <td><form:errors path="addr.roomNumber" /></td>
            </tr>
		</table>
		<button type="submit" class="btn btn-outline-success">Sign-Up</button>
	</form:form>
</div>
</body>

</html>