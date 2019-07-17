<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="index.jsp" />

<div class="container">
	<h1>Add Product</h1>
	<form:form modelAttribute="product" action="/product" method="post">
		<table>
			<tr>
				<td>Product Name</td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" /></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><form:input path="category" /></td>
				<td><form:errors path="category" /></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><form:password path="price" /></td>
				<td><form:errors path="price" /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><form:input path="quantity" /></td>
				<td><form:errors path="quantity" /></td>
			</tr>
			<tr>
				<td>Detail</td>
				<td><form:input path="detail" /></td>
				<td><form:errors path="detail" /></td>
			</tr>
			<tr>
				<td>Image</td>
				<td><form:input path="image" /></td>
				<td><form:errors path="image" /></td>
			</tr>
		</table>
		<button type="submit" class="btn btn-outline-success">Add Product</button>
	</form:form>
</div>
</body>

</html>