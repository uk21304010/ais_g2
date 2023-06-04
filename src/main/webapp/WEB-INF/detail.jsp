<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
ArrayList<Product> showDetail = (ArrayList) request.getAttribute("result");
%>
<body>
	<table>
		<tr>
			<td>섬네</td>
			<td>제목</td>
			<td>내용</td>
			<%
			for (Product pr : showDetail) {
			%>
		
		<tr>
			<td><%=pr.getThumbnailScreen()%></td>
			<td><%=pr.getTitlePlace()%></td>
			<td><%=pr.getDetailContent()%></td>
		</tr>
			<%
			}
			%>
		
	</table>
</body>
</html>