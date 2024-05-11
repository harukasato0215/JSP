<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file = "c.jsp" %>
   <%
   Date date = new Date();
    simpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
    String today =sdf.format(date);
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>どこつぶへようこそ</h1>

<%=name %>は<%=today %>

</body>
</html>