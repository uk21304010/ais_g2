<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>���i�ꗗ</title></head>
<body>
	<h1>���i�ꗗ</h1>
	<table border="1">
		<tr><th>���i�R�[�h</th><th>���i��</th><th>���i</th></tr>
		<c:forEach var="product" items="${result}">
			<tr><td>${product}</td><td>${product}</td><td>${product}</td></tr>
		</c:forEach>
	</table>
</body>
</html>
