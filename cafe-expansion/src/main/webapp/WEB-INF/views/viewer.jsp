<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/viewer.css" />

<div class="viewer-header">
    <c:if test="${not empty sessionScope.user}">
        <span class="viewer-user">${sessionScope.user.nickname}님 
            <a href="${pageContext.request.contextPath}/logout" class="btn-logout">로그아웃</a>
        </span>
    </c:if>
    <c:if test="${empty sessionScope.user}">
        <a href="${pageContext.request.contextPath}/login" class="btn-login">로그인</a>
    </c:if>
    <!-- 목록 버튼만 유지 -->
    <a href="${pageContext.request.contextPath}/detail?bookId=${book.id}" class="btn-library">목록</a>
</div>

<div class="viewer-container">
    <div class="viewer-main">
        <!-- 페이지 네비게이션 화살표 - 콘텐츠 영역 내부 -->
        <c:if test="${pageIndex > 0}">
            <a class="page-nav-arrow page-nav-left"
               href="${pageContext.request.contextPath}/viewer?bookId=${book.id}&episodeId=${episode.id}&page=${pageIndex-1}">&#8249;</a>
        </c:if>
        <c:if test="${pageIndex == 0 && prevEpisodeId != null}">
            <a class="page-nav-arrow page-nav-left"
               href="${pageContext.request.contextPath}/viewer?bookId=${book.id}&episodeId=${prevEpisodeId}&page=${prevEpisodeLastPage}">&#8249;</a>
        </c:if>

        <c:if test="${pageIndex < totalPages-1}">
            <a class="page-nav-arrow page-nav-right"
               href="${pageContext.request.contextPath}/viewer?bookId=${book.id}&episodeId=${episode.id}&page=${pageIndex+1}">&#8250;</a>
        </c:if>
        <c:if test="${pageIndex == totalPages-1 && nextEpisodeId != null}">
            <a class="page-nav-arrow page-nav-right"
               href="${pageContext.request.contextPath}/viewer?bookId=${book.id}&episodeId=${nextEpisodeId}&page=0">&#8250;</a>
        </c:if>

        <!-- 이전화/다음화 네비게이션 -->
        <div class="episode-nav">
            <c:if test="${prevEpisodeId != null}">
                <a href="${pageContext.request.contextPath}/viewer?bookId=${book.id}&episodeId=${prevEpisodeId}&page=0" class="episode-nav-btn">
                    &#8249; 이전화
                </a>
            </c:if>
            <span class="episode-nav-current">${episode.episodeNo}화</span>
            <c:if test="${nextEpisodeId != null}">
                <a href="${pageContext.request.contextPath}/viewer?bookId=${book.id}&episodeId=${nextEpisodeId}&page=0" class="episode-nav-btn">
                    다음화 &#8250;
                </a>
            </c:if>
        </div>

        <div class="episode-title">${episode.title}</div>
        <div class="viewer-meta">
            <b>${book.title}</b> | ${episode.episodeNo}화 | 
			<fmt:formatDate value="${episode.regDateAsDate}" pattern="yyyy-MM-dd" />
        </div>
        <div class="episode-content">
            <c:choose>
                <c:when test="${not empty pages && pageIndex >= 0 && pageIndex < pages.size()}">
                    <c:out value="${pages[pageIndex]}" escapeXml="false"/>
                </c:when>
                <c:otherwise>
                    <p>콘텐츠를 불러올 수 없습니다.</p>
                    <p>디버그 정보:</p>
                    <p>- 총 페이지 수: ${totalPages}</p>
                    <p>- 현재 페이지: ${pageIndex}</p>
                    <p>- Episode ID: ${episode.id}</p>
                    <p>- Content 길이: ${empty episode.content ? '내용 없음' : episode.content.length()}</p>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="viewer-pagenum">${pageIndex+1} / ${totalPages}</div>
    </div>
</div>

<!-- 댓글 영역 -->
<%@ include file="comments.jsp" %>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>