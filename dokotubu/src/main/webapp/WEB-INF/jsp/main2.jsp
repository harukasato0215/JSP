<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://jaca.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
<c:out value="${loginUser.name }"/>さんログイン中
<a href="Logout">ログアウト</a>
</p>

<p><a href="Main">更新</a>
<form action="Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">

</form>
<c: if test ="${not empty errorMsg }" >
<p><c:out value="${errorMsg}"  /></p>
</c:if>
<c:foreach var="mutter" items="${mutterList }">
<c:out value = "${mutter.userName }"/>
<c:out value = "${mutter.text }"/></p>

</body>
</html>