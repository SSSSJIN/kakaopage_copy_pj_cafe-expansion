<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="main-container" style="max-width:1200px; margin:0 auto; padding:32px 0;">
  <%@ include file="/WEB-INF/views/common/recentBooks.jsp" %>

  <!-- 탭 영역 -->
  <div class="tabs">
    <a href="?tab=hot" class="tab${param.tab == 'hot' || empty param.tab ? ' tab-active' : ''}">지금 핫한</a>
    <a href="?tab=ranking" class="tab${param.tab == 'ranking' ? ' tab-active' : ''}">실시간 랭킹</a>
  </div>

  <!-- 탭별 책 리스트 -->
  <div class="cards">
    <c:choose>
      <c:when test="${param.tab == 'ranking'}">
        <c:forEach var="book" items="${rankingBooks}">
          <div class="card">
            <a href="/books/${book.id}">
              <img src="${book.image}" alt="${book.title}">
              <div style="margin-top:8px; font-weight:bold;">${book.title}</div>
              <div style="color:#555;">${book.author}</div>
            </a>
          </div>
        </c:forEach>
      </c:when>
      <c:otherwise>
        <c:forEach var="book" items="${hotBooks}">
          <div class="card">
            <a href="/books/${book.id}">
              <img src="${book.image}" alt="${book.title}">
              <div style="margin-top:8px; font-weight:bold;">${book.title}</div>
              <div style="color:#555;">${book.author}</div>
            </a>
          </div>
        </c:forEach>
      </c:otherwise>
    </c:choose>
  </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
