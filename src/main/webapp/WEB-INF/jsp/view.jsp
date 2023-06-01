<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>商品一覧</title></head>
<body>
	<h1>商品一覧</h1>
	<table border="1">
		<tr><th>商品コード</th><th>商品名</th><th>価格</th></tr>
		<c:forEach var="product" items="${result}">
			<tr><td>${product}</td><td>${product}</td><td>${product}</td></tr>
		</c:forEach>
	</table>
</body>
</html>
