<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>CatPage 메인</title>
  <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<header>
  <%@ include file="/WEB-INF/views/common/header.jsp" %>
</header>
  <!-- 1) 최근 본 책 (로그인 시에만) -->
  <c:if test="${not empty recentBooks}">
    <h2 class="section-title">최근 본 책</h2>
    <section class="books-grid">
      <c:forEach var="book" items="${recentBooks}">
        <div class="book-item">
          <a href="<c:url value='/books/${book.id}'/>">
            <img src="${book.image}" alt="${book.title}" />
          </a>
        </div>
      </c:forEach>
    </section>
  </c:if>

  <!-- 2) 탭 -->
  <nav class="tabs">
    <button type="button" class="tab tab-active" data-target="hot">지금핫한</button>
    <button type="button" class="tab"             data-target="ranking">실시간랭킹</button>
  </nav>

  <!-- 3) 지금핫한 -->
  <section id="hot" class="books-grid">
    <c:forEach var="book" items="${mainContents}">
      <div class="book-item">
        <a href="<c:url value='/books/${book.id}'/>">
          <img src="${book.image}" alt="${book.title}" />
        </a>
      </div>
    </c:forEach>
  </section>

  <!-- 4) 실시간랭킹 -->
  <section id="ranking" class="books-grid" style="display:none">
    <c:forEach var="book" items="${rankingList}">
      <div class="book-item">
        <a href="<c:url value='/books/${book.id}'/>">
          <img src="${book.image}" alt="${book.title}" />
        </a>
      </div>
    </c:forEach>
  </section>
<footer>
  <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</footer>
  <script>
    // 탭 토글 스크립트
    document.querySelectorAll('.tab').forEach(function(btn) {
      btn.addEventListener('click', function() {
        document.querySelectorAll('.tab').forEach(function(t) {
          t.classList.remove('tab-active');
        });
        btn.classList.add('tab-active');
        var tgt = btn.getAttribute('data-target');
        document.getElementById('hot').style.display     = (tgt==='hot')     ? 'grid' : 'none';
        document.getElementById('ranking').style.display = (tgt==='ranking') ? 'grid' : 'none';
      });
    });
  </script>
</body>
</html>
