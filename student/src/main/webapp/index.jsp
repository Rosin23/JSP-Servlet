<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet.do">Hello Servlet</a>
<br>
<a href="/student/list.do">list출력</a>
<br>
<a href="/student/view?id=student1.do">view조회</a>
<br>
<a href="/student/register.do">등록</a>
<br>
<a href="/student/update.do">수정</a>
<br>
<a href="/student/delete.do">삭제</a>
</body>
</html>