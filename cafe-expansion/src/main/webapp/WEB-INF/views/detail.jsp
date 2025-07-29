<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="detail-container">
  <div class="detail-main">
    <!-- 책 표지 -->
    <div class="detail-cover">
		<img src="${pageContext.request.contextPath}/resources/image/${book.image}" alt="${book.title}">
    </div>
    <!-- 책 정보 -->
    <div class="detail-info">
      <div class="detail-title">${book.title}</div>
      <div class="detail-meta">${book.author} | ${book.genre}</div>
      <div class="detail-desc">${book.description}</div>
      <div class="detail-actions">
        <!-- 좋아요 버튼 -->
        <form method="post" action="${pageContext.request.contextPath}/like">
          <input type="hidden" name="bookId" value="${book.id}">
          <button type="submit" class="like-btn">&#10084;</button> <!-- 하트 아이콘 -->
        </form>
        <!-- 다음화 보기 버튼 -->
        <a href="${pageContext.request.contextPath}/viewer?bookId=${book.id}&episodeId=${nextEpisodeId}" class="next-ep-btn">다음화 보기</a>
      </div>
    </div>
  </div>

  <!-- 상단 탭 -->
  <div class="detail-tabs">
    <button class="detail-tab active" onclick="showTab('episode')">홈</button>
    <button class="detail-tab" onclick="showTab('info')">정보</button>
    <button class="detail-tab" onclick="showTab('news')">소식</button>
  </div>

  <!-- 탭별 컨텐츠: 기본값은 에피소드 -->
  <div id="tab-episode" class="episode-list">
    <c:forEach var="ep" items="${episodes}">
      <div class="episode-item">
        <div class="episode-title">
          <a href="${pageContext.request.contextPath}/viewer?bookId=${book.id}&episodeId=${ep.id}">
            ${ep.title}
          </a>
        </div>
        <div class="episode-date">${ep.date}</div>
      </div>
    </c:forEach>
  </div>
  <div id="tab-info" style="display:none;">
    <div style="margin-top:24px; color:#555;">${book.description}</div>
    <!-- 추가 정보 영역 -->
  </div>
  <div id="tab-news" style="display:none;">
    <div style="margin-top:24px; color:#555;">작가/작품 소식이 여기에 표시됩니다.</div>
    <!-- 실제 구현 시 news 리스트 반복 -->
  </div>

  <!-- 전체 댓글 섹션 -->
  <div class="comment-section">
  <h3>전체 댓글</h3>
  <form method="post" action="${pageContext.request.contextPath}/comment">
    <input type="hidden" name="bookId" value="${book.id}">
    <textarea name="content" rows="3" style="width:100%;" placeholder="댓글을 입력하세요"></textarea>
    <button type="submit" style="margin-top:8px;">댓글 등록</button>
  </form>
  <div class="comment-list">
    <c:forEach var="comment" items="${comments}">
      <div class="comment-item">
        <div class="comment-meta">
          ${comment.writer} | <fmt:formatDate value="${comment.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
        </div>
        <div class="comment-content">${comment.content}</div>
      </div>
    </c:forEach>
  </div>
  </div>

<script>
function showTab(tab) {
  document.getElementById('tab-episode').style.display = (tab === 'episode') ? '' : 'none';
  document.getElementById('tab-info').style.display = (tab === 'info') ? '' : 'none';
  document.getElementById('tab-news').style.display = (tab === 'news') ? '' : 'none';
  var tabs = document.querySelectorAll('.detail-tab');
  tabs.forEach(function(btn) { btn.classList.remove('active'); });
  if(tab === 'episode') tabs[0].classList.add('active');
  if(tab === 'info') tabs[1].classList.add('active');
  if(tab === 'news') tabs[2].classList.add('active');
}
</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
