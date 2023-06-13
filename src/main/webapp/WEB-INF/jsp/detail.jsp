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
<jsp:include page="header.jsp"></jsp:include>
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
<script>
        function refreshPage() {
         location.reload(true);
        }
    </script>
</head>
<headr></headr>
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
<td><img src="<%=pr.getThumbnailScreen()%>"></td>
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
        String query = " SELECT DISTINCT "
                + "at.attraction_num,  "
                + "DECODE(at.attraction_num, "
               +    "1, '上野公園', "
                +    "2, '浅草寺', "
                +   "3, '渋谷スカイ', "
                +   "4, '一蘭', "
                +  "5, 'お台場', "
                + " 6, '横浜', "
                + " 7, 'お台場') AS title, "
                + " at.img_name"
             + " from attraction_tbl at, keyword_tbl kt "
             + " where at.attraction_num = ? or at.attraction_num = ? or at.attraction_num = ? or at.attraction_num = ? ";
       
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 0; i < randomNumbers.size(); i++) {
            statement.setInt(i + 1, randomNumbers.get(i)); // 쿼리의 ? 부분에 난수 값을 바인딩
        }

        ResultSet resultSet = statement.executeQuery();
        String path = "image\\";
        // 3. 결과 출력
        while (resultSet.next()) {
            int attractionNum = resultSet.getInt("attraction_num");
            String imgName =path+resultSet.getString("img_name");
            String subName = resultSet.getString("title");
            // 각 행의 값을 출력
            %>
<tr>

<td><a href="detail?NUM=<%=attractionNum %>"><img src="<%= imgName %>"></a></td><br/>
<td><%= subName %></td>



</tr>
<%
        }
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
<tr>
<td>타이틀</td>
</tr>
</table>
</body>
</html>