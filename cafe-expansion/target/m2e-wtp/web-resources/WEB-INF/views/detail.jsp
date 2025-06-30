<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<style>
/* 간단한 스타일 (필요시 style.css로 이동) */
.detail-container { max-width: 900px; margin: 40px auto; background: #fff; padding: 36px 32px 32px 32px; border-radius: 12px; box-shadow: 0 2px 12px #0001; }
.detail-main { display: flex; gap: 32px; }
.detail-cover { width: 220px; }
.detail-cover img { width: 100%; border-radius: 10px; box-shadow: 0 3px 12px #0002; }
.detail-info { flex: 1; }
.detail-title { font-size: 2rem; font-weight: bold; margin-bottom: 10px; }
.detail-meta { color: #888; font-size: 1.1rem; margin-bottom: 8px; }
.detail-desc { margin: 18px 0 24px 0; color: #444; }
.detail-actions { display: flex; gap: 24px; align-items: center; margin-bottom: 24px; }
.like-btn { background: none; border: none; cursor: pointer; font-size: 1.7rem; color: #f7b500; }
.next-ep-btn { background: #f7b500; color: #fff; border: none; border-radius: 8px; padding: 10px 32px; font-size: 1.1rem; font-weight: bold; cursor: pointer; }
.detail-tabs { display: flex; gap: 20px; margin-top: 28px; }
.detail-tab { background: none; border: none; font-size: 1.1rem; padding: 8px 16px; border-radius: 8px; cursor: pointer; color: #222; }
.detail-tab.active { background: #f7b50022; color: #f7b500; font-weight: bold; }
.episode-list { margin-top: 24px; }
.episode-item { display: flex; align-items: center; gap: 12px; padding: 10px 0; border-bottom: 1px solid #eee; }
.episode-title { font-weight: 500; }
.comment-section { margin-top: 40px; }
.comment-list { margin-top: 16px; }
.comment-item { padding: 12px 0; border-bottom: 1px solid #f1f1f1; }
.comment-meta { color: #888; font-size: 0.96rem; margin-bottom: 4px; }
.comment-content { font-size: 1.08rem; }
</style>

<div class="detail-container">
  <div class="detail-main">
    <!-- 책 표지 -->
    <div class="detail-cover">
      <img src="${book.imageUrl}" alt="${book.title}">
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
          <div class="comment-meta">${comment.nickname} | ${comment.date}</div>
          <div class="comment-content">${comment.content}</div>
        </div>
      </c:forEach>
    </div>
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
