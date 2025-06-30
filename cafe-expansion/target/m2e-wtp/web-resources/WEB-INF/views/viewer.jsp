<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<style>
.viewer-container { max-width: 800px; margin: 40px auto; background: #fff; padding: 36px 32px; border-radius: 12px; box-shadow: 0 2px 12px rgba(0,0,0,0.1); }
.viewer-title { font-size: 1.8rem; font-weight: bold; margin-bottom: 16px; }
.viewer-content { margin: 24px 0; line-height: 1.8; color: #333; }
.viewer-meta { color: #888; font-size: 1rem; margin-bottom: 24px; }
.viewer-nav { display: flex; justify-content: space-between; margin-top: 32px; }
.viewer-nav-btn { background: #f7b500; color: #fff; border: none; border-radius: 8px; padding: 10px 24px; font-size: 1rem; cursor: pointer; }
</style>

<div class="viewer-container">
  <h1 class="viewer-title">${episode.title}</h1>
  <div class="viewer-meta">
    ${book.title} | ${episode.episodeNo}화 | ${episode.regDate}
  </div>
  <div class="viewer-content">
    <!-- 실제 에피소드 내용이 여기에 표시됩니다. -->
    <p>여기에 에피소드 내용이 들어갑니다. DB에서 가져온 내용을 출력하세요.</p>
    <!-- 예시: ${episode.content} -->
  </div>
  <div class="viewer-nav">
    <button class="viewer-nav-btn" onclick="location.href='${pageContext.request.contextPath}/detail?bookId=${book.id}'">목록으로</button>
    <button class="viewer-nav-btn" onclick="location.href='${pageContext.request.contextPath}/viewer?bookId=${book.id}&episodeId=${nextEpisodeId}'">다음화</button>
  </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
