<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <title>보관함 | 카카오페이지 카피캣</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body style="background-color:#121212; color:#fff;">

  <div style="max-width:1200px; margin:40px auto;">

    <!-- 탭 네비게이션 -->
    <div style="display:flex; gap:20px; margin-bottom:30px;">
      <a href="${pageContext.request.contextPath}/collection"
         style="padding:8px 16px; background:#333; border-radius:4px; text-decoration:none; color:#fff;">
        최근 본
      </a>
      <a href="${pageContext.request.contextPath}/collection?tab=liked"
         style="padding:8px 16px; background:#333; border-radius:4px; text-decoration:none; color:#fff;">
        좋아요
      </a>
    </div>

    <!-- 책 카드 그리드 -->
    <div style="display:flex; flex-wrap:wrap; gap:20px;">
      <c:forEach var="book" items="${recentBooks}">
        <div style="width:calc(20% - 16px); background:#222; border-radius:8px; overflow:hidden;">
          <a href="${pageContext.request.contextPath}/book/${book.id}">
            <img src="${book.thumbnail}"
                 alt="${book.title}"
                 style="width:100%; display:block;"/>
            <div style="padding:8px;">
              <h3 style="margin:0; font-size:16px; color:#fff;">${book.title}</h3>
              <p style="margin:4px 0 0; font-size:14px; color:#ccc;">${book.author}</p>
            </div>
          </a>
        </div>
      </c:forEach>
    </div>

  </div>

  <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
