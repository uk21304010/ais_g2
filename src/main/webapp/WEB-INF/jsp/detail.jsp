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

#big {
	display: flex;
	flex-direction: row; justify-content : center; position : absolute;
	flex-direction : row; justify-content : center; position : absolute;
	left: 100px;
	justify-content: center;
	position: absolute;
	flex-direction: row;
	justify-content: center;
	position: absolute;
}
</style>
</head>
<%
ArrayList<Product> showDetail = (ArrayList) request.getAttribute("result");
%>
<script type="text/javascript">
function setTimeOut(){
	setInterval(() => {
		 const move = document.getElementById('big');
		 	const left = window.getComputedStyle(move).left;
		 	//move.style.left = parseInt(left) + 100 + "px";
	}, 2000);

}
	</script>
<body onload="setTimeOut()">
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

			<td>1
				<div id="big">
					<div class="try1 item1"></div>
					<div class="try1 item2"></div>
					<div class="try1 item3"></div>
					<div class="try1 item4"></div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>