<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <title>카카오 로그인 처리 중...</title>
  <style>
    body { background: #f5f5f5; color: #191919; font-family: 'Pretendard', sans-serif; }
    .center-box { max-width: 400px; margin: 120px auto; padding: 40px 20px; background: #fff; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.08); text-align: center; }
    .error { color: #e74c3c; margin-top: 18px; }
  </style>
</head>
<body>
  <div class="center-box">
    <h2>카카오 로그인 처리 중...</h2>
    <p>잠시만 기다려 주세요.</p>
    <c:if test="${not empty error}">
      <div class="error">${error}</div>
      <a href="${pageContext.request.contextPath}/login">로그인 화면으로 돌아가기</a>
    </c:if>
  </div>
</body>
</html>
