<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, dto.*, servlet.*, command.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<style>
img {
  width: 300px;
  height: 300px;
}
footer {
    background-color: pink;
    color: black;
	height: 50px;
  position : relative;
  transform : translateY(-100%);
}
.flex-container{
	display: flex;
	align-items: center;
	justify-content: center;
	margin: 50px;
	justify-content: space-around;
	flex-direction: row;
	flex-wrap: wrap;
}
</style>
<html>
<head>
<meta charset="UTF-8">
<link href="../style/listStyle.css" type="text/css" rel="stylesheet" >
<link href="../style/reset.css" type="text/css" rel="stylesheet" >
<title>キーワードリスト</title>
</head>

<body>
	<%
		Map userID =null;
		if(session.getAttribute("session") !=null){
		 userID = (Map)session.getAttribute("session");
		}
		
		if(userID !=null){

		%> 
			<p class = "title">
			<div class="flex-container">
			<div id="" class="registBtn">
				<input type="button" value="登録" onClick="atRegist()">
			</div>
				<c:forEach items="${requestScope.result }" var="result">
						<div id="anchorDetail">
							<div class="thumnail">
						 		<a href="detail?NUM=${result.anum}"><img src="${result.imgName}"></a>
							</div>
							<p class="attractionName">${result.atName}</p><br>
							<a href="modify?NUM=${result.anum}">修正</a> 
							<a href="delete?ATNUM=${result.anum}">削除</a>
						</div>
				</c:forEach> 
			</div>
		<% }else{%>

			<div class="flex-container">
				<c:forEach items="${requestScope.result }" var="result">
					<div id="anchorDetail">
						<div class="thumnail">
							<a href="detail?NUM=${result.anum }"><img src="${result.imgName}"></a>
						</div>
						<p class="attractionName">${ result.atName }</p>
					</div>
				</c:forEach> 
			</div>
				<%} %>

	
	<script>
		function atRegist() {
			location.href = "input";
		}
	</script>
</body>
<footer><p>© 2023 キーワード探す名所システム</p></footer>
</html>