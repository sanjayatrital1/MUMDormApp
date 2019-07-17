<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<%--    <script src="https://kit.fontawesome.com/8fd24b2ea7.js"></script>--%>
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
<div class="container"><p>${message}</p></div>

</body>

</html>