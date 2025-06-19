<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>게시판 목록</title>
</head>
<body>
  <h2>게시판 목록</h2>
  <p><a href="<c:url value='/boards/new'/>">새 글 작성</a></p>
  <table border="1" cellpadding="5">
    <tr>
      <th>번호</th><th>제목</th><th>작성자</th><th>등록일</th>
    </tr>
    <c:forEach var="b" items="${boards}">
      <tr>
        <td>${b.id}</td>
        <td><a href="<c:url value='/boards/${b.id}'/>">${b.title}</a></td>
        <td>${b.writer}</td>
        <td>${b.regDate}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
