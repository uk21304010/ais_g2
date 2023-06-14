<%@ page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="dto.Product" %>
<%@ page import="java.util.Map" %>
<jsp:useBean id="user" class="dto.Product" scope="page" />
<jsp:setProperty name="user" property="id"  />
<jsp:setProperty name="user" property="pass" />
<jsp:include page="header.jsp"></jsp:include>

<html>
<head><title>管理者ログイン</title>
</head>


<body>
	<h1>管理者ログイン</h1>
	<%
		Map userID =null;
		if(session.getAttribute("session") !=null){
		 userID = (Map)session.getAttribute("session");
		}
		
		if(userID !=null){%>
<script>
		alert('もうログインされてます。');
		history.back();
</script>
		
		
		<% }else{%>
	<form method='get' action='check'>
	ID<input type='text' name='ID'><br>
	Pass<input type='text' name='PASS'><br>
	<input type='submit' value='登録'>
	</form>
	${result}
	<%}%>
	</body>
	<footer>
	</footer>
</html>