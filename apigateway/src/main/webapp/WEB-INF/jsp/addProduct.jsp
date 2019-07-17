<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<jsp:include page="index.jsp" />--%>

<div class="container">
    <h1>Add Product</h1>
    <form:form modelAttribute="product" action="/product/" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>Product Name</td>
                <td><form:input path="productName"/></td>
                <td><form:errors path="productName"/></td>
            </tr>
            <tr>

                <td>Category</td>
                <td>
                    <form:select path="productCategory">
                        <form:option value="NONE" label="Select"/>
                        <form:options items="${categoryList}"/>
                    </form:select>
                </td>

            </tr>
            <tr>
                <td>Price</td>
                <td><form:input path="price"/></td>
                <td><form:errors path="price"/></td>
            </tr>
            <tr>
                <td>Quantity</td>
                <td><form:input path="quantity"/></td>
                <td><form:errors path="quantity"/></td>
            </tr>
            <tr>
                <td>Detail</td>
                <td><form:input path="productDetail"/></td>
                <td><form:errors path="productDetail"/></td>
            </tr>
            <tr>
                <td>Image</td>
                    <%--<td><form:input path="image" /></td>
                    <td><form:errors path="image" /></td>--%>

                    <%--<td><input type = "submit" value = "Upload File" /></td>--%>
                <td>Select a file to upload</td>
                <td><form hidden><input type="file" name="file"/></form></td>
<%--                <td><form:hidden path="image" id="img" /></td>--%>
            </tr>
        </table>
        <button type="submit" class="btn btn-outline-success">Add Product</button>
    </form:form>
</div>
</body>

</html>