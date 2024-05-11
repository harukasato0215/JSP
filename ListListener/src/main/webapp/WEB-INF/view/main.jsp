<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Person.java.utill.List" %>
    <%List<Person> list =(List<Person>) %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>名簿一覧</h1>
<table border="1">
<tr>
<th><%= list.get(0).getName() %></th>
<th><%= list.get(0).getKana() %></th>
<th><%= list.get(0).getGender() %></th>
<th><%= list.get(0).getBlood() %></th>

</tr>
<%for(int i =1;i<list.size();i++){ %>
<tr>
<td><%= list.get(i).getName() %></td>
<td><%= list.get(i).getKana() %></td>
<td><%= list.get(i).getGender() %></td>
<td><%= list.get(i).getBlood() %></td>
<%}%>
</tr>

</table>
</body>
</html>