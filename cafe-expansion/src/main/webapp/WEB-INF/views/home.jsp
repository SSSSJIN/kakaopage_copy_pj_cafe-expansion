<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <title>카카오페이지 카피캣 - 홈</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body style="background-color:#f5f5f5;">
  <div style="max-width:900px; margin:40px auto;">
    <h2>실시간 랭킹</h2>
    <div style="display:flex; gap:24px; flex-wrap:wrap;">
      <c:forEach var="book" items="${rankingBooks}">
        <div style="width:160px; text-align:center;">
          <!-- 상세게시판으로 이동하는 링크 -->
          <a href="${pageContext.request.contextPath}/detail?bookId=${book.id}">
            <img src="${pageContext.request.contextPath}${book.imageUrl}" alt="${book.title}" style="width:100%; border-radius:8px;">
          </a>
          <div style="margin-top:8px;">${book.title}</div>
        </div>
      </c:forEach>
    </div>

    <h2 style="margin-top:48px;">지금 핫한 작품</h2>
    <div style="display:flex; gap:24px; flex-wrap:wrap;">
      <c:forEach var="book" items="${hotBooks}">
        <div style="width:160px; text-align:center;">
          <a href="${pageContext.request.contextPath}/detail?bookId=${book.id}">
            <img src="${pageContext.request.contextPath}${book.imageUrl}" alt="${book.title}" style="width:100%; border-radius:8px;">
          </a>
          <div style="margin-top:8px;">${book.title}</div>
        </div>
      </c:forEach>
    </div>

    <c:if test="${not empty user and not empty recentBooks}">
      <h2 style="margin-top:48px;">최근 본 목록</h2>
      <div style="display:flex; gap:24px; flex-wrap:wrap;">
        <c:forEach var="book" items="${recentBooks}">
          <div style="width:140px; text-align:center;">
            <a href="${pageContext.request.contextPath}/detail?bookId=${book.id}">
              <img src="${pageContext.request.contextPath}${book.imageUrl}" alt="${book.title}" style="width:100%; border-radius:8px;">
            </a>
            <div style="margin-top:8px;">${book.title}</div>
          </div>
        </c:forEach>
      </div>
    </c:if>
  </div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
