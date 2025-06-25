<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <title>메인 화면 | 카카오페이지 카피캣</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
  <style>
    .section { margin: 40px auto; max-width: 1200px; }
    .section h2 { font-size: 1.5rem; margin-bottom: 16px; }
    .card-list {
      display: flex; gap: 16px; overflow-x: auto; padding-bottom: 8px;
    }
    .card {
      flex: 0 0 auto; width: 160px; text-align: center; cursor: pointer;
    }
    .card img { width: 100%; border-radius: 8px; }
    .card-info { margin-top: 8px; }
    .card-info strong { display: block; font-size: 1rem; color: #191919; }
    .card-info p { margin: 4px 0 0; font-size: 0.9rem; color: #666; }

    /* 대표 이벤트 배너 */
    .event-section .banner-list {
      display: flex; gap: 16px; overflow-x: auto;
    }
    .event-section .banner {
      flex: 0 0 auto; width: 100%; max-width: 360px;
      border-radius: 8px; overflow: hidden; cursor: pointer;
    }
    .event-section .banner img {
      width: 100%; display: block;
    }
  </style>
</head>
<body>
  <!-- 지금 핫한 -->
  <div class="section">
    <h2>지금 핫한</h2>
    <div class="card-list">
      <c:forEach var="book" items="${hotBooks}">
        <div class="card" onclick="location.href='${pageContext.request.contextPath}/book/${book.id}'">
          <img src="${book.thumbnail}" alt="${book.title} 표지"/>
          <div class="card-info">
            <strong>${book.title}</strong>
            <p>${book.author}</p>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>

  <!-- 실시간 랭킹 -->
  <div class="section">
    <h2>실시간 랭킹</h2>
    <div class="card-list">
      <c:forEach var="book" items="${rankingBooks}">
        <div class="card" onclick="location.href='${pageContext.request.contextPath}/book/${book.id}'">
          <img src="${book.thumbnail}" alt="${book.title} 표지"/>
          <div class="card-info">
            <strong>${book.title}</strong>
            <p>${book.author}</p>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>

  <!-- 대표 이벤트 -->
  <div class="section event-section">
    <h2>대표 이벤트</h2>
    <div class="banner-list">
      <c:forEach var="evt" items="${events}">
        <a class="banner" href="${evt.linkUrl}">
          <img src="${evt.imageUrl}" alt="${evt.title}"/>
        </a>
      </c:forEach>
    </div>
  </div>

  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>
