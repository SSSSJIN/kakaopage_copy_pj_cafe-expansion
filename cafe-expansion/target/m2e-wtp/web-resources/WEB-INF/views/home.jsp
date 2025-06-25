<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <title>홈 | 카카오페이지 카피캣</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

  <!-- 1) 대표 이벤트: 가장 위로 이동 -->
  <section class="events-section" style="margin: 40px auto; max-width: 1200px;">
    <h2 style="color: #fff; margin-bottom: 20px;">대표 이벤트</h2>
    <div style="display: flex; gap: 20px;">
      <c:forEach var="evt" items="${events}">
        <a href="${pageContext.request.contextPath}${evt.linkUrl}"
           style="flex:1; display:block; overflow:hidden; border-radius:8px;">
          <img src="${evt.imageUrl}"
               alt="${evt.title}"
               style="width:100%; height:auto; display:block;"/>
        </a>
      </c:forEach>
    </div>
  </section>

  <!-- 2) 지금 핫한 -->
  <section class="hot-section" style="margin: 40px auto; max-width: 1200px;">
    <h2 style="color: #fff; margin-bottom: 20px;">지금 핫한</h2>
    <div class="card-container" style="display: flex; flex-wrap: wrap; gap: 20px;">
      <c:forEach var="book" items="${hotBooks}">
        <div class="card" style="width: calc(20% - 16px); background:#222; color:#fff; border-radius:8px; overflow:hidden;">
          <a href="${pageContext.request.contextPath}/book/${book.id}">
            <img src="${book.thumbnail}"
                 alt="${book.title}"
                 style="width:100%; height: auto;"/>
            <div style="padding:8px;">
              <h3 style="margin:0 0 4px;font-size:16px;">${book.title}</h3>
              <p style="margin:0;font-size:14px;color:#ccc;">${book.author}</p>
            </div>
          </a>
        </div>
      </c:forEach>
    </div>
  </section>

  <!-- 3) 실시간 랭킹 -->
  <section class="ranking-section" style="margin: 40px auto 80px; max-width: 1200px;">
    <h2 style="color: #fff; margin-bottom: 20px;">실시간 랭킹</h2>
    <div class="card-container" style="display: flex; flex-wrap: wrap; gap: 20px;">
      <c:forEach var="book" items="${rankingBooks}">
        <div class="card" style="width: calc(20% - 16px); background:#222; color:#fff; border-radius:8px; overflow:hidden;">
          <a href="${pageContext.request.contextPath}/book/${book.id}">
            <img src="${book.thumbnail}"
                 alt="${book.title}"
                 style="width:100%; height: auto;"/>
            <div style="padding:8px;">
              <h3 style="margin:0 0 4px;font-size:16px;">${book.title}</h3>
              <p style="margin:0;font-size:14px;color:#ccc;">${book.author}</p>
            </div>
          </a>
        </div>
      </c:forEach>
    </div>
  </section>

  <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
