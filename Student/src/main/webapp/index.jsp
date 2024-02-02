<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br>
<a href="/student/list">list출력</a>
<br>
<a href="/student/view?id=student1">view조회</a>
<br>
<a href="/student/register">등록</a>
<br>
<a href="/student/update">수정</a>
<br>
<a href="/student/delete">삭제</a>
</body>
</html>