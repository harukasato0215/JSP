<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おすすめ映画メイン</title>
</head>
<body>
<h1>おすすめ映画</h1>
<p><%= loginUser.getName() %>さん、ログイン中</p>
<form action="Main" method="post">
タイトル：<input type="text" name="title">
一言：<input type="text" name="mutter">
</form>
</body>
</html>