<%@ page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="dto.Product" %>
<%@ page import="java.util.Map" %>
<jsp:useBean id="user" class="dto.Product" scope="page" />
<jsp:setProperty name="user" property="id"  />
<jsp:setProperty name="user" property="pass" />
<jsp:include page="header.jsp"></jsp:include>
<%@page import="java.io.*" import="java.sql.*" import="java.util.*"
	import="dao.ContentInfoDao"%>
<%
ArrayList<Product> list = new ArrayList<Product>();
ContentInfoDao cd = new ContentInfoDao();
%>
<html>
<head><title>商品登録</title>
</head>
<header>
<div>
		<div class="dropmenu">
			<ul>
				<li class="dropmenu_li">						
					<div class="liList">名所</div>
						<ul>
							<%
							list = cd.showSub("t001");
							for (Product p : list) {
							%>
							<li><a href="list?keyNum=<%=p.getAtNum()%>"><%=p.getName()%></a></li>
							<%
							}
							%>
						</ul>
					</li>
					<li class="dropmenu_li">
						<div class="liList">グルメ</div>
						<ul>
							<%
							list = cd.showSub("t002");
							for (Product p : list) {
							%>
							<li><a href="list?keyNum=<%=p.getAtNum()%>"><%=p.getName()%></a></li>
							<%
							}
							%>
						</ul>
					</li>
					<li class="dropmenu_li">
						<div class="liList">ショッピング</div>
						<ul>
							<%
							list = cd.showSub("t003");
							for (Product p : list) {
							%>
							<li><a href="list?keyNum=<%=p.getAtNum()%>"><%=p.getName()%></a></li>
							<%
							}
							%>
						</ul>
					</li>
				
					<li class="liList_search_li">
						<div class="liList_search">
							<input type="text" class="liList_search_text"
								placeholder="검색어 입력" maxlength="100">
							<button type="submit" class="liList_search_btn">검색</button>
						</div>
					</li>
				</ul>
			</div>
		</div>
</header>

<body>
	<h1>商品登録</h1>
	<%
		Map userID =null;
		if(session.getAttribute("session") !=null){
		 userID = (Map)session.getAttribute("session");
		}
		
		if(userID !=null){%>
<script>
		alert('이미 로그인중');
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
	<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</html>