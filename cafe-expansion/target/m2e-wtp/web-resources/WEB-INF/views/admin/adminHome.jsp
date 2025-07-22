<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/views/admin/adminHeader.jsp" %>
<div class="admin-nav">
  <a href="/admin/user">회원 관리</a> |
  <a href="/admin/book">작품 관리</a> |
  <a href="/admin/board">게시판/댓글 관리</a> |
  <a href="/admin/event-slider">이벤트 슬라이더 관리</a> |
  <a href="/admin/manager">중간관리자 관리</a> |
  <a href="/admin/stats">통계/로그</a> |
  <a href="/admin/system">시스템 설정</a>
</div>
<div class="admin-content">
  <h2>관리자 메인</h2>
  <p>관리 기능을 선택하세요.</p>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
