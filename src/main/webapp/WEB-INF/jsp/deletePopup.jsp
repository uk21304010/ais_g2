<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, dto.*, servlet.*, command.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>		
	<%
		boolean result = (boolean)request.getAttribute("result");
		
		if(result == true){
	%>
		<script type="text/javascript">
			alert("삭제 성공했어유");
			location.href = ""
		</script>
	<%
		}else {
	%>
		<script type="text/javascript">
			alert("삭제 실패라능");
			location.href = ""
		</script>
	<%		
		}
	%>
	<%
	%>
</body>
</html>