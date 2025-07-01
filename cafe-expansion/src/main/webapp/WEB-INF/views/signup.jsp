<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <title>회원가입 | 카카오페이지 카피캣</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
  <!-- 카카오 JS SDK -->
  <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
  <script>
    Kakao.init('a43481684e7ca266c31cb57d5ffed16f');
    function kakaoLogin() {
      Kakao.Auth.authorize({
        redirectUri: 'http://localhost:8080/cafe-expansion/kakao-callback'
      });
    }
  </script>
  
</head>
<body>
  <div class="kakao-box">
    <img src="${pageContext.request.contextPath}/resources/image/kakao_logo.png" alt="kakao" class="kakao-logo">
    <!-- 카카오 공식 로그인 버튼 -->
    <button type="button" class="kakao-btn" onclick="kakaoLogin()">
      <img src="${pageContext.request.contextPath}/resources/image/kakao_login_medium.png" alt="카카오로 회원가입">
    </button>
    <div>
      <a href="${pageContext.request.contextPath}/login" class="link">로그인</a>
    </div>
  </div>
  <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
