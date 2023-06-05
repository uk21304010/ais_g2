<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
	<%@ page import="java.io.PrintWriter" %>

<html>
<head><title>商品登録</title></head>
<body>
	<h1>商品登録</h1>
	<form method='post' action='check'>
	ID<input type='text' name='ID'><br>
	Pass<input type='text' name='PASS'><br>
	<input type='submit' value='登録'>
	</form>
	${result}
	</body>
</html>