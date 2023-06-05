<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@page import="java.io.*" import="java.sql.*" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
<head>

<title>Sakura-スレッド一覧</title>
</head>
<header>

</header>
<body>
	<h1>Sakuraスレッド一覧</h1>
				<form method='get' action='updatedetail'>
  <select name='COMBO' >
	<%
	PreparedStatement ps = null;
	Connection cn = null;

	Class.forName("oracle.jdbc.OracleDriver");

	//Oracleに接続する
	cn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/xe", "hr", "hr");

	String select = ("Select KEYWORD_NAME from KEYWORD_TBL");
	Statement st = cn.createStatement();
	ResultSet result = st.executeQuery(select);
	while (result.next()) {
		String printid = "null";
		String printdate;
		%>
		<option><%=result.getString("KEYWORD_NAME")%></option>
		
		<%
		}
		%>
		</select>
			<h1>送信テスト</h1>
			<input type ='hidden' value= "${result.anum}" name='ANUM'><br>
	商品番号<input type='text' value=" ${result.name}" name='NAME'><br>
	商品名<input type='text' value=" ${result.con}"name='CON'><br>
	価格<input type='text' value="${result.img}" name='IMG'><br>
	<input type='submit' value='登録'>
	</form>
</body>
</html>