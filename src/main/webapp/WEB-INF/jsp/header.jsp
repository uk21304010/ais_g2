<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
    <%@page import="dao.ListInfoDao"%>
    <%@ page import="dto.Product" %>
<%@ page import="java.util.Map" %>
<%@page import="java.io.*" import="java.sql.*" import="java.util.*"
	import="dao.ContentInfoDao"%>

<%
ArrayList<Product> list = new ArrayList<Product>();
ContentInfoDao cd = new ContentInfoDao();
%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
</head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<style type="text/css">

header {
   margin: 0;
   padding: 0;
   position: sticky;
   height: 80px;
   top: 0;
   background-color: pink;
   z-index: 10;
}

header h1 {
   padding: 10px 20px;
   margin: 0;
}

.keyword_title {
   text-align: center;
}





/* 아코디언 메뉴 */
.dropmenu {
   display: grid;
   border: none;
   background: rgb(242, 185, 194);
   border: 0px;
   justify-content: center;
   margin: 0px;
   padding: 0px;
   font-size: 18px;
}

.dropmenu ul {
   background: rgb(242, 185, 194);
   height: 100px;
   list-style: none;
   margin: 0;
   padding: 0;
}

.dropmenu_li {
   float: left;
   padding: 0px;
   width: 10vw;
}

.dropmenu_li div {
   background: rgb(242, 185, 194);
   color: black;
   display: block;
   line-height: 100px;
   margin: 0px;
   padding: 0px 15px;
   text-align: center;
   text-decoration: none;
}

.dropmenu_li a {
   background: pink;
   color: black;
   display: block;
   line-height: 100px;
   margin: 0px;
   padding: 0px 25px;
   text-align: center;
   text-decoration: none;
}

.dropmenu_li div:hover {
   background: rgb(253, 123, 145);
   color: black;
   text-decoration: none;
}

.dropmenu_li ul {
   display: none;
   height: auto;
   border: 0px;
   position: absolute;
   width: 10vw;
   z-index: 200;
}

.dropmenu_li:hover ul {
   display: block;
}

.dropmenu_li li {
   display: block;
   float: none;
   margin: 0px;
   padding: 0px;
   width: 10vw;
}

.dropmenu_li:hover li div {
   background: none;
}

.dropmenu_li ul div {
   display: block;
   height: 80px;
   font-size: 14px;
   margin: 0px;
   padding: 0px 10px 0px 15px;
   text-align: left;
}

.dropmenu_li ul li:hover a {
   background: rgb(241, 117, 138);
   border: 0px;
   color: pink;
   text-decoration: none;
}

.dropmenu p {
   clear: left;
}

.liList_search_li {
   float: left;
   padding: 0px;
   width: 20vw;
}

.liList_search {
   line-height: 100px;
   float: right;
}

.liList_search_text {
   height: 50px;
}

.liList_search_btn {
   width: 100px;
   height: 50px;
   color: whitesmoke;
   font-size: larger;
   font-weight: 800;
   background-color: #e85072;
   border-radius: 5px;
}

.liList_search_btn:hover {
   background-color: #f7c6d0df;
   color: #e85072;
   cursor: pointer;
}

/* 아코디언 메뉴 */
</style>
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
			</div></div></header>
<body>
<div id="wrap" class="wrap">
      <header class="grid">
         <h1 class="title">
            <a href="header.html">キーワード探す名所システム</a>
         </h1>
      </header>

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
</body>
</html>