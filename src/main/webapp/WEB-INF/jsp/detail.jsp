<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.id {
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
}

.try1 {
	width: 100px;
	height: 100px;
	background: orange;
	margin: 5px;
}

/* #big {
	display: flex;
	flex-direction: row; justify-content : center; position : absolute;
	flex-direction : row; justify-content : center; position : absolute;
	left: 100px;
	justify-content: center;
	position: absolute;
	flex-direction: row;
	justify-content: center;
	position: absolute;
} */
</style>
</head>
<%
ArrayList<Product> showDetail = (ArrayList) request.getAttribute("result");
ArrayList<Product> showSub = (ArrayList) request.getAttribute("subResult");
%>
<script type="text/javascript">
function setTimeOut(){
	setInterval(() => {
		 const move = document.getElementById('big');
		 	const left = window.getComputedStyle(move).left;
		 	move.style.left = parseInt(left) + 100 + "px";
	}, 2000);

}
	</script>
<div class="id">
	<table border="1" align="center">
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
</div>

<table>
	<tr>

		<td>
			<h2 align="center">おすすめ</h2>
		</td>
	</tr>
	<%
	for (Product ss : showSub) {
	%>
	<tr>
		<td>서브타이틀</td>
	</tr>
	<tr>
		<td>서브섬네일화면1</td>
		<td><%=ss.getSubthumbScreen() %></td>
	</tr>
	<tr>
		<td>서브섬네일화면2</td>
		<td><%=ss.getSubthumbScreen() %></td>
	</tr>
	<tr>
		<td>서브섬네일화면3</td>
		<td><%=ss.getSubthumbScreen() %></td>
	</tr>
	<tr>
		<td>서브섬네일화면4</td>
		<td><%=ss.getSubthumbScreen() %></td>
	</tr>

	<tr>
		<td>타이틀</td>
	</tr>
	<%
	}
	%>
</table>
</body>
</html>