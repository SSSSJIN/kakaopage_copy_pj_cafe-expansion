<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="comments-section">
    <h3>댓글</h3>
    <c:choose>
        <c:when test="${not empty comments}">
            <c:forEach var="cmt" items="${comments}">
                <div class="comment-item">
                    <span class="comment-writer">${cmt.writer}</span>
                    <span class="comment-date"><fmt:formatDate value="${cmt.regDate}" pattern="yyyy-MM-dd HH:mm"/></span>
                    <div class="comment-content">${cmt.content}</div>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <div style="color:#b8b693;">아직 댓글이 없습니다.</div>
        </c:otherwise>
    </c:choose>

    <c:if test="${not empty sessionScope.user}">
        <form class="comment-form" method="post" action="${pageContext.request.contextPath}/comment">
            <input type="hidden" name="bookId" value="${book.id}" />
            <input type="hidden" name="episodeId" value="${episode.id}" />
            <textarea name="content" required placeholder="댓글을 입력하세요"></textarea>
            <button type="submit">댓글 작성</button>
        </form>
    </c:if>
    <c:if test="${empty sessionScope.user}">
        <div style="margin-top:15px;">
            <a href="${pageContext.request.contextPath}/login">로그인 후 댓글 작성 가능</a>
        </div>
    </c:if>
</div>
