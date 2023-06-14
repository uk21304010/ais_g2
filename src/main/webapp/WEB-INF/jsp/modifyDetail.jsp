<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@page import="java.io.*" import="java.sql.*" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE>
<html>
<head>

<title>コンテンツ修正</title>
</head>
<header>

</header>
<body>
	<h1>キーワード名</h1>
				<form method='post' action='updatedetail' enctype="multipart/form-data">
  <select name='COMBO' >
	<%
	PreparedStatement ps = null;
	Connection cn = null;

	Class.forName("oracle.jdbc.OracleDriver");

	//Oracleに接続する
	cn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/xe", "hr", "hr");

	String select = ("Select KEYWORD_NUM,KEYWORD_NAME from KEYWORD_TBL");
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

			<h1>コンテンツ修正</h1>
			<input type ='hidden' value="${result.anum}" name='ANUM'multiple><br>
	タイトル　<input type='text' value="${result.name}" name='NAME'multiple><br>
	コンテンツ<textarea name='CON'　cols="30" rows="5" style ="resize :none">${result.con}</textarea><br> 
	イメージ　<input type='file' name='IMG'multiple><br>
	<input type='submit' value='登録'>
	</form>
</body>
</html>