<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <title>보관함 | 카카오페이지 카피캣</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body style="background-color:#f5f5f5;">
  <div style="max-width:800px; margin:40px auto;">
    <h2>내 보관함</h2>
    <div style="display:flex; gap:24px; flex-wrap:wrap;">
      <c:forEach var="img" items="${pageContext.request.contextPath}/resources/image/img_41.jpg,${pageContext.request.contextPath}/resources/image/img_42.jpg,${pageContext.request.contextPath}/resources/image/img_43.jpg,${pageContext.request.contextPath}/resources/image/img_44.jpg,${pageContext.request.contextPath}/resources/image/img_45.jpg".split(",") varStatus="status">
        <div style="width:140px; text-align:center;">
          <a href="${pageContext.request.contextPath}/detail?bookId=${status.index + 31}">
            <img src="${img}" alt="보관함 더미" style="width:100%; border-radius:8px;">
          </a>
          <div style="margin-top:8px;">보관 작품 ${status.index + 1}</div>
        </div>
      </c:forEach>
    </div>
  </div>
</body>
</html>
