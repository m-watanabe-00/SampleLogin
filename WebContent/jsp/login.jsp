<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="../css/common.css">
</head>
<body>
	<p>${member.msg}</p>
	<form action = "../svlt/loginServlet" method = "post">
		<input type = "text" name="id" value="${member.id}" placeholder="ID"/>
		<input type="password" name="password" value="${member.password}" placeholder="PASS"/>
		<input type="submit" value="ログイン"/>
	</form>
</body>
</html>