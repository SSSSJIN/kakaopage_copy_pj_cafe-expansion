<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<h2>실시간 랭킹</h2>
<!-- 랭킹 기준 안내 -->
<div class="ranking-info" style="margin-bottom:16px;">
  <strong>[랭킹 산정 기준]</strong>
  최근 1시간(또는 24시간) 내 열람수·구매·찜(좋아요) 등 사용자 반응을 점수화(열람+1, 구매+3, 찜+2)하여 집계하고, 이에 기반해 실시간 순위를 제공합니다.<br>
  각 책 우측 하단의 <span style="color:#ff647e;">▲</span>/<span style="color:#1e90ff;">▼</span>는 전 시간 대비 순위 변동을 나타냅니다.
</div>
<div class="book-card">
  <img src="${pageContext.request.contextPath}/resources/image/${book.image}" alt="${book.title}">
  <div class="rank-indicator">
    <c:choose>
      <c:when test="${book.rankChange > 0}">
        <span class="rank-up">▲ +${book.rankChange}</span>
      </c:when>
      <c:when test="${book.rankChange < 0}">
        <span class="rank-down">▼ ${book.rankChange}</span>
      </c:when>
      <c:otherwise>
        <span class="rank-same">-</span>
      </c:otherwise>
    </c:choose>
    <span class="current-rank">${book.currentRank}위</span>
  </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
