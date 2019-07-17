<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<jsp:include page="home.jsp" />--%>

<div class="container">
	<h1>Add Product</h1>
	<form:form action="/product/" method="post">
		<div>
			<span>Product Name: </span><input type="text" name="productname"/>
		</div>
		<div>
			<span>Category </span>
			<select>
				<option value="notebook">Notebook</option>


				<option value="smartphone">Smartphone</option>

				<option value="accessories">Accessories</option>
			</select>
		</div>
		<div>
			<span>Price: </span><input type="text" name="price"/>
		</div>
		<div>
			<span>Quantity: </span><input type="number" name="quantity"/>
		</div>
		<div>
			<span>Detail: </span><input type="text" name="detail"/>
		</div>
		<div>
			<span>Image: </span><input type="file" name="image" accept="image/*">
		</div>
		<button type="submit" class="btn btn-outline-success">Add Product</button>
	</form:form>
</div>
</body>

</html>