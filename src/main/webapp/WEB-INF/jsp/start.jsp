<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Start</title>
	</head>
	<style>

	
	</style>
	<body>
		<form method="get" action="detail">
			<table border="1" align="center">
				<tr>
					<td><input type="text" name="NUM" value="" /><br /></td>
					<td><input type="submit" value="詳細画面" /></td>
				</tr>
			</table>

	
		</form>
<p><a href="input">作成画面</a></p>
	<p><a href="modify?NUM=2">修正画面</a></p>
	<p><a href="login">login画面</a></p>
	<p><a href="list?keyNum=100">リスト画面へ番号</a></p>
<body>
		<form method="get" action="list">
			<table border="1" align="center">
				<tr>
					<td><input type="text" name="keyName" value="" /><br /></td>
					<td><input type="submit" value="伝送" /></td>
				</tr>
			</table>

		</form>

	<p><a href="main">メイン画面へ</a></p>

	</body>
	</html>