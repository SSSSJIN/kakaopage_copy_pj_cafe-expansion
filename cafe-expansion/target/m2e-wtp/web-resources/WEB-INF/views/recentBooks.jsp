<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <title>${headerTitle} | 카카오페이지 카피캣</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body style="background-color:#f5f5f5;">
  <div style="max-width:800px; margin:40px auto;">
    <h2>${headerTitle}</h2>
    <p>${guideText}</p>

    <c:choose>
      <c:when test="${not empty bookList}">
        <div style="display:flex; gap:18px; flex-wrap:wrap;">
          <c:forEach var="book" items="${bookList}">
            <div style="width:140px; background:#fff; border-radius:8px; box-shadow: 0 2px 8px rgba(0,0,0,0.06); padding:10px;">
              <a href="${pageContext.request.contextPath}/detail?bookId=${book.id}">
                <img src="${pageContext.request.contextPath}/resources/image/${book.image}" alt="${book.title}" style="width:100%; border-radius:4px;" />
              </a>
              <div style="margin-top:8px; font-weight:bold; font-size:14px;">${book.title}</div>
              <div style="color:#555; font-size:12px;">${book.author}</div>
            </div>
          </c:forEach>
        </div>
      </c:when>
      <c:otherwise>
        <p>아직 본 책이 없습니다.</p>
      </c:otherwise>
    </c:choose>
  </div>
</body>
</html>
