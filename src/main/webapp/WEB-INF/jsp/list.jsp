<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, dto.*, servlet.*, command.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link href="../style/listStyle.css" type="text/css" rel="stylesheet" >
<link href="../style/reset.css" type="text/css" rel="stylesheet" >
<title>Insert title here</title>
</head>
<body>
	<%
		Map userID =null;
		if(session.getAttribute("session") !=null){
		 userID = (Map)session.getAttribute("session");
		}
		
		if(userID !=null){

		%> 
	<section id="alSec">
		<div class="bgImg"></div>
		<article id="listWrap">
			<div id="" class="registBtn">
				<input type="button" value="登録" onClick="atRegist()">
			</div>
			<!-- <form action="" method="post" name="FRM"> -->
			<ul id="attractionListWrap" class="listWrap">
				<c:forEach items="${requestScope.result }" var="result">
					<li class="attractionList">
						<div id="anchorDetail">
							<div class="thumnail">
								<img src="${result.imgName}">
							</div>
							<p class="attractionName">${ result.atName }</p>
						</div>
						<div id="adminBtnWrap">
							<a href="attractionModify.jsp?ATNUM=102">修正</a> <a
								href="delete?ATNUM=5"">削除</a>
						</div>
					</li>
				</c:forEach> 
		<% }else{%>

		<section id="alSec">
		<div class="bgImg"></div>
		<article id="listWrap">
			<div id="" class="registBtn">
			</div>
			<!-- <form action="" method="post" name="FRM"> -->
			<ul id="attractionListWrap" class="listWrap">
				<c:forEach items="${requestScope.result }" var="result">
					<li class="attractionList">
						<div id="anchorDetail">
							<div class="thumnail">
								<img src="${result.imgName}">
							</div>
							<p class="attractionName">${ result.atName }</p>
						</div>
						<div id="adminBtnWrap">

						</div>
					</li>
				</c:forEach> 
				<%} %>
				<%--<%
				for (Product l : list) {
				%>
				<li class="attractionList">
					<div id="anchorDetail">
						<div class="thumnail">
							<img src="<%=l.getImgName()%>">
						</div>
						<p class="attractionName"><%=l.getAtName()%></p>
					</div>
					<div id="adminBtnWrap">
						<a href="attractionModify.jsp?ATNUM=102"">修正</a> 
						<a href="delete?ATNUM=5"">削除</a>
					</div>
				</li>
				<%
				}
				%>
			</ul>--%>
			<!-- </form> -->
		</article>
	</section>
	<script>
		function atRegist() {
			location.href = "input";
		}
	</script>
</body>
</html>