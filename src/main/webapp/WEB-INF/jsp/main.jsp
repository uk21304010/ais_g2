
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ListInfoDao"%>
<%@page import="java.io.*" import="java.sql.*" import="java.util.*"
   import="dao.ContentInfoDao"%>
<%
ArrayList<Product> list = new ArrayList<Product>();
ContentInfoDao cd = new ContentInfoDao();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>MAIN画面</title>
<style type="text/css">
/* 다이렉트로 css코드를 넣으면 가독성 떨어지는데 현재 css파일을 인식하지 못하는 상황이라서 넣음
   1. WEB-INF 파일 밑에 css 파일 두면 적용되지 않는다(그래서 css 파일을 WEB-INF상위 디렉토리로 설정했는데도 결과는 똑같았음)
   2. 인터넷 검색 결과 xml매핑문제라고 생각이 됩니다. wed.xml 파일 17~18번째줄 수정을 해야 할거 같음
   ※ 참고 자료 :  https://yunamom.tistory.com/163*/
   
   
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

.keyword_list {
   display: grid;
   border: none;
   background: #eee;
   border: 0px;
   justify-content: center;
   margin: 5vw 0 0 0;
   padding: 0px;
   font-size: 18px;
}

.keyword_list ul {
   list-style: none;
   margin: 0;
   padding: 0;
}

.keyword_list li {
   float: left;
   padding: 0px;
   width: 15vw
}

.keyword_list li div {
   cursor: pointer;
   color: black;
   line-height: 100px;
   text-align: center;
   text-decoration: none;
}

.keyword_list li a {
   background: pink;
   color: black;
   display: block;
   line-height: 100px;
   margin: 0px;
   text-align: center;
   text-decoration: none;
}

.keyword_list li div:hover {
   background: rgb(253, 123, 145);
   color: black;
   text-decoration: none;
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
   width: 15vw;
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
   width: 15vw;
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

/* 화면슬라이드 */
html, body {
   position: relative;
   height: 100%;
}

body {
   background: #eee;
   font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
   font-size: 14px;
   color: #000;
   margin: 0;
   padding: 0;
}

.swiper {
   width: 50%;
   height: 50%;
}

.swiper-slide {
   text-align: center;
   font-size: 18px;
   background: #fff;
   display: flex;
   justify-content: center;
   align-items: center;
}

.swiper-slide img {
   display: block;
   object-fit: cover;
}

.autoplay-progress {
   position: absolute;
   right: 16px;
   bottom: 16px;
   z-index: 10;
   width: 48px;
   height: 48px;
   display: flex;
   align-items: center;
   justify-content: center;
   font-weight: bold;
   color: var(- -swiper-theme-color);
}

.autoplay-progress svg {
   -progress: 0;
   position: absolute;
   left: 0;
   top: 0px;
   z-index: 10;
   width: 100%;
   height: 100%;
   stroke-width: 4px;
   stroke: var(- -swiper-theme-color);
   fill: none;
   stroke-dashoffset: calc(125.6 * ( 1 - var(- -progress)));
   stroke-dasharray: 125.6;
   transform: rotate(-90deg);
}

/* 화면슬라이드 */
footer {
   z-index: 100;
   display: flex;
   justify-content: center;
   padding: 5px;
   background-color: pink;
   color: black;
   bottom: 0;
   position: sticky;
}
</style>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css?ver=1" />

</head>
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

         <h1 class="keyword_title">該当キーワードイメージ</h1>
         <!-- Swiper -->
         <div class="swiper mySwiper">
            <div class="swiper-wrapper">
               <div class="swiper-slide">
                  <img class="img"
                     src="https://image.walkerplus.com/wpimg/walkertouch/wtd/event/62/n/380662_1.jpg?x=1920&notupsize=1" />
               </div>
               <div class="swiper-slide">
                  <img class="img"
                     src="https://a.cdn-hotels.com/gdcs/production27/d1140/483394d2-8ce9-416a-b8e6-cb31f5f851d3.jpg?impolicy=fcrop&w=800&h=533&q=medium" />
               </div>
               <div class="swiper-slide">
                  <img class="img"
                     src="https://rimage.gnst.jp/livejapan.com/public/article/detail/a/00/00/a0000003/img/basic/a0000003_main.jpg?20201223103545" />
               </div>
               <div class="swiper-slide">
                  <img class="img"
                     src="https://rimage.gnst.jp/livejapan.com/public/article/detail/a/00/04/a0004438/img/basic/a0004438_main.png?20200711233445" />
               </div>
               <div class="swiper-slide">
                  <img class="img"
                     src="https://img.kojodan.com/photo/104314.jpg" />
               </div>
            </div>
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
            <div class="swiper-pagination"></div>
            <div class="autoplay-progress">
               <svg viewBox="0 0 48 48">
              <circle cx="24" cy="24" r="20"></circle>
            </svg>
               <span></span>
            </div>
         </div>
         <div class="keyword_list">
            <ul>
               
               <li><a href="detail?NUM=1"><div class="liList">桜</div></a>
               </li>
               
               <li><a href="detail?NUM=2"><div class="liList">神社</div></a>
               </li>
               
               <li><a href="detail?NUM=3"><div class="liList">ランドマーク</div></a>
               </li>
               
               <li><a href="detail?NUM=4"><div class="liList">グルメ</div></a>
               </li>
               
               
            </ul>
         </div>
      </div>

      <!-- footer -->
      <footer>
         <p>© 2023 キーワード探す名所システム</p>
      </footer>
   </div>

   <script
      src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>

   <!-- Initialize Swiper -->
   <script>


    const progressCircle = document.querySelector(".autoplay-progress svg");
    const progressContent = document.querySelector(".autoplay-progress span");
    var swiper = new Swiper(".mySwiper", {
      spaceBetween: 30,
      centeredSlides: true,
      autoplay: {
        delay: 4000,
        disableOnInteraction: false
      },
      pagination: {
        el: ".swiper-pagination",
        clickable: true
      },
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev"
      },
      on: {
        autoplayTimeLeft(s, time, progress) {
          progressCircle.style.setProperty("--progress", 1 - progress);
          progressContent.textContent = `${Math.ceil(time / 1000)}s`;
        }
      }
    });
  </script>

</body>
<footer>

</footer>
</html>