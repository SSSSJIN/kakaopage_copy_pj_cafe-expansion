<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <title>이벤트 | 카카오페이지 카피캣</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
  <style>
    .event-wrapper { max-width:1200px; margin:40px auto; }
    .event-banner img {
      width:100%; border-radius:8px; display:block;
    }
    .event-info {
      margin-top:16px; font-size:18px; color:#191919;
    }
    .recommend-section { margin:60px 0 40px; }
    .recommend-section h2 { font-size:1.5rem; margin-bottom:16px; }
    .recommend-list {
      display:flex; gap:16px; flex-wrap:wrap;
    }
    .recommend-item {
      width:160px; text-align:center; cursor:pointer;
    }
    .recommend-item img {
      width:100%; border-radius:8px;
    }
    .recommend-item p {
      margin-top:8px; font-size:1rem; color:#191919;
    }
  </style>
</head>
<body>
  <div class="event-wrapper">
    <!-- 이벤트 대표 이미지 -->
    <div class="event-banner">
      <a href="${event.linkUrl}" target="_blank">
        <img src="${event.imageUrl}" alt="${event.title}"/>
      </a>
    </div>

    <!-- 이벤트 제목 및 기간 -->
    <div class="event-info">
      <h1>${event.title}</h1>
      <p>기간: <c:out value="${event.startDate}"/> ~ <c:out value="${event.endDate}"/></p>
    </div>

    <!-- 추천 책 이미지 버튼 -->
    <div class="recommend-section">
      <h2>추천 책</h2>
      <div class="recommend-list">
        <c:forEach var="book" items="${recBooks}">
          <div class="recommend-item" onclick="location.href='${pageContext.request.contextPath}/book/${book.id}'">
            <img src="${book.thumbnail}" alt="${book.title} 표지"/>
            <p>${book.title}</p>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>

  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>
