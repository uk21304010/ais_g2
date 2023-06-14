<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto.*, java.util.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Random"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

img {
  width: 150px;
  height: 150px;
}
  table {
    width: 400px;
    height: 200px;
    float: right;
  }
.thumbnail {
width: 600px;
height: 240px;
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

.footer {
display: flex;
flex-direction: row; footer { z-index : 100;
display: flex;
justify-content: center;
padding: 5px;
background-color: pink;
color: black;
bottom: 0;
position: sticky;
}
/* .sub {
display: table;
} */
.sub {
	display: inline-block;
	flex-direction: row;
	 justify-content: space-around;
}


</style>
<script>
        function refreshPage() {
         location.reload(true);
        }
    </script>
</head>
<header>

<jsp:include page="header.jsp"></jsp:include>

</header>

<%
ArrayList<Product> showDetail = (ArrayList) request.getAttribute("result");
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
<body>

<%
for (Product pr : showDetail) {
%>
<div class ="flex-container">
<table border="1" align="center" >

<tr align="center">

<td colspan ="2"><%=pr.getTitlePlace()%></td>
</tr>


<tr class="thumbnail" border="1">
<td><img src="<%=pr.getThumbnailScreen()%>" /></td>
<td><%=pr.getDetailContent()%></td>
</tr>
<%
}
%>
</table>
</div>
<%
// 1. 난수 생성
Random random = new Random();
int min = 1;
int max = 6;
int count = 4;
List<Integer> randomNumbers = new ArrayList<>();

for (int i = 0; i < count; i++) {
int randomNumber = random.nextInt(max - min + 1) + min;
randomNumbers.add(randomNumber);
}

// 2. DB 연결 및 쿼리 실행
String url = "jdbc:oracle:thin:@//localhost:1521/xe"; // DB 연결 정보 입력
String username = "hr"; // DB 사용자명 입력
String password = "hr"; // DB 비밀번호 입력

try {
Class.forName("oracle.jdbc.OracleDriver"); // JDBC 드라이버 로드

Connection connection = DriverManager.getConnection(url, username, password);
String query = " SELECT DISTINCT " + "at.attraction_num,  " + "DECODE(at.attraction_num, " + "1, '上野公園', "
+ "2, '浅草寺', " + "3, '渋谷スカイ', " + "4, '一覧', " + "5, 'お台場', " + " 6, '横浜', " + " 7, 'お台場') AS title, "
+ " at.img_name" + " from attraction_tbl at, keyword_tbl kt "
+ " where at.attraction_num = ? or at.attraction_num = ? or at.attraction_num = ? or at.attraction_num = ? ";

PreparedStatement statement = connection.prepareStatement(query);
for (int i = 0; i < randomNumbers.size(); i++) {
statement.setInt(i + 1, randomNumbers.get(i)); // 쿼리의 ? 부분에 난수 값을 바인딩
}

ResultSet resultSet = statement.executeQuery();
%>
<div>
		<h2 align="center">おすすめ</h2>
	</div>
<div class ="flex-container">
	
<%
// 3. 결과 출력
String path = "image\\";
while (resultSet.next()) {
int attractionNum = resultSet.getInt("attraction_num");
String imgName = path+resultSet.getString("img_name");
String subName = resultSet.getString("title");
// 각 행의 값을 출력
%>

<div><a href="detail?NUM=<%=attractionNum%>"><img src="<%= imgName %>"></a><br><%=subName%></div>




<%
}
%>

<% 
// 4. 자원 해제
resultSet.close();
statement.close();
connection.close();
} catch (ClassNotFoundException e) {
e.printStackTrace();
} catch (SQLException e) {
e.printStackTrace();
}
// 5. 다시 페이지 호출을 위한 리다이렉트
%>

</div>

<footer>
<p>© 2023 キーワード探す名所システム</p>
</footer>


</body>
</html>