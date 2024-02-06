<%--
  Created by IntelliJ IDEA.
  User: Rosin
  Date: 2024-01-31
  Time: 오후 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cfmt" uri="http://nhnacademy.com/cfmt" %>
<html>
<head>
    <title>학생-조회</title>
    <link rel="stylesheet" href="/style.css" />
</head>
<body>
<table>
    <tbody>

        <tr>
            <td style="width: 30%" >아이디</td>
            <td style="width: 70%" >${student.id}</td>
        </tr>
        <tr>
            <td style="width: 30%" >이름</td>
            <td style="width: 70%" >${student.name}</td>
        </tr>
        <tr>
            <td style="width: 30%" >성별</td>
            <td style="width: 70%" >${student.gender}</td>
        </tr>
        <tr>
            <td style="width: 30%" >나이</td>
            <td style="width: 70%" >${student.age}</td>
        </tr>
        <tr>
            <td style="width: 30%" >등록일</td>
            <td style="width: 70%" >${cfmt:formatDate(student.createdAt, 'yyyy-MM-dd HH:mm:ss')}</td>
        </tr>

    </tbody>
</table>
<ul>
    <li><a href="/student/list.do">리스트</a></li>
    <li>
        <!-- todo  설정 c:url -->
        <c:url var="update_link" value="/student/update.do" >
            <c:param name="id" value="${student.id}" />
        </c:url>
        <a href="${update_link}">수정</a>
        <br/>
    </li>

    <li>
        <form method="post" action="/student/delete.do">
            <input type="hidden" name="id" value="${student.id}" />
            <button type="submit">삭제</button>
        </form>
    </li>
</ul>
</body>
</html>