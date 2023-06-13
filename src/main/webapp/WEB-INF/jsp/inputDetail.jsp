<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@page import="java.io.*" import="java.sql.*" import="java.util.*"%>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE>
<html>
<head>

<title>コンテンツ登録</title>
</head>

<body>
	<h1>キーワード名</h1>
	<form method='post' action='create' enctype="multipart/form-data">
		<select name='COMBO' required>
			<%
	PreparedStatement ps = null;
	Connection cn = null;

	Class.forName("oracle.jdbc.OracleDriver");

	//Oracleに接続する
	cn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/xe", "hr", "hr");

	String select = ("Select KEYWORD_NUM, KEYWORD_NAME from KEYWORD_TBL");
	Statement st = cn.createStatement();
	ResultSet result = st.executeQuery(select);
	while (result.next()) {
		String printid = "null";
		String printdate;
		%>
		<option value=<%=result.getString("KEYWORD_NUM")%>>
		<%=result.getString("KEYWORD_NAME")%></option>
			
			<%
		}
		%>
		</select>

		<h1>新規登録</h1>
		タイトル　<input type='text' name='NAME' multiple><br> 
		コンテンツ<textarea name='CON' cols="30" rows="5" style ="resize :none" ></textarea><br> 
		イメージ　<input type='file' name='file' multiple><br> 
		<input type='submit' value='登録'>
	</form>
	${result}

</body>
</html>