<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="/static/css/viewer.css" />

<div class="viewer-header">
    <c:if test="${not empty sessionScope.user}">
        <span class="viewer-user">${sessionScope.user.nickname}님 
            <a href="${pageContext.request.contextPath}/logout" class="btn-logout">로그아웃</a>
        </span>
    </c:if>
    <c:if test="${empty sessionScope.user}">
        <a href="${pageContext.request.contextPath}/login" class="btn-login">로그인</a>
    </c:if>
    <a href="${pageContext.request.contextPath}/library" class="btn-library">내 책장</a>
</div>

<div class="viewer-container">
    <c:if test="${pageIndex > 0}">
        <a class="nav-arrow nav-arrow-left"
           href="${pageContext.request.contextPath}/viewer?bookId=${book.id}&episodeId=${episode.id}&page=${pageIndex-1}">&#10094;</a>
    </c:if>

    <div class="viewer-main">
        <div class="episode-title">${episode.title}</div>
        <div class="viewer-meta">
            <b>${book.title}</b> | ${episode.episodeNo}화 | 
			<fmt:formatDate value="${episode.regDateAsDate}" pattern="yyyy-MM-dd" />
        </div>
        <div class="episode-content">
            <c:out value="${pages[pageIndex]}" escapeXml="false"/>
        </div>
        <div class="viewer-pagenum">${pageIndex+1} / ${totalPages}</div>
    </div>

    <c:if test="${pageIndex < totalPages-1}">
        <a class="nav-arrow nav-arrow-right"
           href="${pageContext.request.contextPath}/viewer?bookId=${book.id}&episodeId=${episode.id}&page=${pageIndex+1}">&#10095;</a>
    </c:if>
</div>

<!-- 댓글 영역 -->
<%@ include file="comments.jsp" %>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
