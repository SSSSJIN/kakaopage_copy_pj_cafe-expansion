<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>게시글 작성/수정</title>
</head>
<body>
  <h2>
    <c:choose>
      <c:when test="${board.id != null}">게시글 수정</c:when>
      <c:otherwise>새 게시글 작성</c:otherwise>
    </c:choose>
  </h2>
  <form action="<c:choose>
                   <c:when test='${board.id != null}'>
                     <c:url value='/boards/${board.id}/edit'/>
                   </c:when>
                   <c:otherwise>
                     <c:url value='/boards'/>
                   </c:otherwise>
                 </c:choose>"
        method="post">
    <input type="hidden" name="id" value="${board.id}"/>
    <p>제목: <input type="text" name="title" value="${board.title}" size="60"/></p>
    <p>작성자: <input type="text" name="writer" value="${board.writer}" size="20"/></p>
    <p>내용:<br/>
      <textarea name="content" rows="10" cols="80">${board.content}</textarea>
    </p>
    <button type="submit">
      <c:choose>
        <c:when test="${board.id != null}">수정</c:when>
        <c:otherwise>등록</c:otherwise>
      </c:choose>
    </button>
    <a href="<c:url value='/boards'/>">목록으로</a>
  </form>
</body>
</html>
