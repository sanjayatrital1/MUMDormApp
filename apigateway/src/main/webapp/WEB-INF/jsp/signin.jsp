<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="index.jsp" />

<div class="container">
	<h1>Sign-In</h1>
	<form:form action="/users/login" method="post">
		<div>
			<span>Email Address: </span><input type="email" name="email"/>
		</div>
		<div>
			<span>Password: </span><input type="password" name="password"/>
		</div>
		<button type="submit" class="btn btn-outline-success">Sign-In</button>
	</form:form>
</div>
</body>

</html>