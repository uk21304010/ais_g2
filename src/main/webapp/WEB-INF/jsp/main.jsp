<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>MAIN画面</title>
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

header h1{
    padding: 10px 20px;
    margin: 0;
}

.keyword_title{
  text-align: center;
}

.keyword_list{
  display: grid;
  border: none;
  background: #eee;
  border: 0px;
  justify-content: center;
  margin: 5vw 0 0 0;
  padding: 0px;
  font-size: 18px;
}

.keyword_list ul{
    list-style:none;
    margin:0;
    padding:0;
}

.keyword_list li{
    float:left;
    padding:0px;
    width: 15vw
}

.keyword_list li div{
  cursor: pointer;
  color:black;
  line-height:100px;
  text-align:center;
  text-decoration:none;
}

.keyword_list li a{
    background: pink;
    color:black;
    display:block;
    line-height:100px;
    margin:0px;
    text-align:center;
    text-decoration:none;
}

.keyword_list li div:hover{
    background: rgb(253, 123, 145);
    color:black;
    text-decoration:none;
}

/* 아코디언 메뉴 */
.dropmenu{
  display: grid;
  border: none;
  background: rgb(242, 185, 194);
  border: 0px;
  justify-content: center;
  margin: 0px;
  padding: 0px;
  font-size: 18px;
}

.dropmenu ul{
    background: rgb(242, 185, 194);
    height:100px;
    list-style:none;
    margin:0;
    padding:0;
}

.dropmenu li{
    float:left;
    padding:0px;
    width: 10vw;
}

.dropmenu li div{
    background: rgb(242, 185, 194);
    color:black;
    display:block;
    line-height:100px;
    margin:0px;
    padding:0px 15px;
    text-align:center;
    text-decoration:none;
}

.dropmenu li a{
    background: pink;
    color:black;
    display:block;
    line-height:100px;
    margin:0px;
    padding:0px 25px;
    text-align:center;
    text-decoration:none;
}

.dropmenu li div:hover, .dropmenu ul li:hover div{
    background: rgb(253, 123, 145);
    color:black;
    text-decoration:none;
}

.dropmenu li ul{
    display:none;
    height:auto;
    border:0px;
    position:absolute;
    width:10vw;
    z-index:200;
}

.dropmenu li:hover ul{
    display:block;
}

.dropmenu li li {
    display:block;
    float:none;
    margin:0px;
    padding:0px;
    width:10vw;
}

.dropmenu li:hover li div{
    background:none;
}

.dropmenu li ul div{
    display:block;
    height:80px;
    font-size:14px;
    margin:0px;
    padding:0px 10px 0px 15px;
    text-align:left;
}

.dropmenu li ul li:hover a{
    background: rgb(241, 117, 138);
    border:0px;
    color:pink;
    text-decoration:none;
}

.dropmenu p{
    clear:left;
}

.liList_search{
  position: fixed;
  right: 5px;
}

.liList_search_text{
  height: 50px;
  margin-top: 25px;
}

.liList_search_btn{
  width: 100px;
    height: 50px;
    color: whitesmoke;
    font-size: larger;
    font-weight: 800;
    background-color: #e85072;
    border-radius: 5px;
}

.liList_search_btn:hover{
  background-color: #f7c6d0df;
  color: #e85072;
  cursor: pointer;
}

/* 아코디언 메뉴 */

/* 화면슬라이드 */
  html,
  body {
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
    color: var(--swiper-theme-color);
  }

  .autoplay-progress svg {
    --progress: 0;
    position: absolute;
    left: 0;
    top: 0px;
    z-index: 10;
    width: 100%;
    height: 100%;
    stroke-width: 4px;
    stroke: var(--swiper-theme-color);
    fill: none;
    stroke-dashoffset: calc(125.6 * (1 - var(--progress)));
    stroke-dasharray: 125.6;
    transform: rotate(-90deg);
  }

/* 화면슬라이드 */

footer {
    display: flex;
    justify-content: center;
    padding: 5px;
    background-color: pink;
    color: black;
    bottom: 0;
    position: sticky;
}
</style>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />

</head>

<body>
  <div id="wrap" class="wrap">
    <header class="grid">
      <h1 class="title">
        <a href="header.html">title</a>
      </h1>
    </header>

    <div>
      <div class="dropmenu">
        <ul>
          <li>
            <div class="liList">main01</div>
            <ul>
              <li><a href="m1.html">메뉴1</a></li>
              <li><a href="m2.html">메뉴2</a></li>
              <li><a href="m3.html">메뉴3</a></li>
            </ul>
          </li>
          <li><div class="liList">main02</div>
            <ul>
              <li><a href="m1-1.html">메뉴4</a></li>
              <li><a href="m1-2.html">메뉴5</a></li>
              <li><a href="m1-3.html">메뉴6</a></li>
            </ul>
          </li>
          <li><div class="liList">관광지</div>
            <ul>
              <li><a href="m1-1.html">오다이바</a></li>
              <li><a href="m1-2.html">지브리</a></li>
              <li><a href="m1-3.html">롯본기</a></li>
            </ul>
          </li>
          <li><div class="liList">우에노</div>
            <ul>
              <li><a href="m1-1.html">공원</a></li>
              <li><a href="m1-2.html">라면집</a></li>
              <li><a href="m1-3.html">마라탕</a></li>
            </ul>
          </li>
          <li><div class="liList">아키바</div>
            <ul>
              <li><a href="m1-1.html">게임센터</a></li>
              <li><a href="m1-2.html">인형뽑기</a></li>
              <li><a href="m1-3.html">피규어</a></li>
            </ul>
          </li>
          <li><div class="liList">신오쿠보</div>
            <ul>
              <li><a href="m1-1.html">고기</a></li>
              <li><a href="m1-2.html">술집</a></li>
              <li><a href="m1-3.html">카페</a></li>
            </ul>
          </li>
          <li><div class="liList">와규</div>
            <ul>
              <li><a href="m1-1.html">고베규</a></li>
              <li><a href="m1-2.html">야키니쿠</a></li>
              <li><a href="m1-3.html">무한리필</a></li>
            </ul>
          </li>
          <li></li>
        </ul>
        <div class="liList_search">
          <input type="text" class="liList_search_text" placeholder="검색어 입력"maxlength="100">
          <button type="submit" class="liList_search_btn">검색</button>
        </div>
      </div>

      <h1 class="keyword_title">該当キーワードイメージ</h1>
      <!-- Swiper -->
        <div class="swiper mySwiper">
          <div class="swiper-wrapper">
            <div class="swiper-slide">
              <img class="img" src="https://upload.wikimedia.org/wikipedia/ko/4/4a/%EC%8B%A0%EC%A7%B1%EA%B5%AC.png" />
            </div>
            <div class="swiper-slide">
              <img class="img" src="https://theyouthdream.com/files/attach/images/2023/02/24/0f5848e7a1d0586dc69f3d291a319615.jpeg" />
            </div>
            <div class="swiper-slide">
              <img class="img" src="https://cdn.pixabay.com/photo/2020/12/30/14/23/waterfall-5873630_1280.jpg" />
            </div>
            <div class="swiper-slide">
              <img class="img" src="https://upload.wikimedia.org/wikipedia/ko/4/4a/%EC%8B%A0%EC%A7%B1%EA%B5%AC.png" />
            </div>
            <div class="swiper-slide">
              <img class="img" src="https://cdn.pixabay.com/photo/2020/12/30/14/23/waterfall-5873630_1280.jpg" />
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
          <li>
            <a href="t.html"><div class="liList">도쿄</div></a>
          </li>
          <li>
            <a href="o.html"><div class="liList">오사카</div></a>
          </li>
          <li>
            <a href="k.html"><div class="liList">큐슈</div></a>
          </li>
          <li>
            <a href="h.html"> <div class="liList">후쿠오카</div></a>
          </li>
        </ul>
      </div>
            <h1>메인</h1>
            <h1>메인</h1>
            <h1>메인</h1>
      </div>

        <!-- footer -->
        <footer>
            <p>© 2018 Gandalf</p>
        </footer>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>

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
</html>