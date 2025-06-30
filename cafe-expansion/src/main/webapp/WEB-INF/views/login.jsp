<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <title>카카오페이지 카피캣 | 카카오로 시작하기</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
  <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
  <script>
    Kakao.init('a43481684e7ca266c31cb57d5ffed16f'); // 반드시 JavaScript 키로 교체!
    function kakaoLogin() {
      Kakao.Auth.authorize({
        redirectUri: 'http://localhost:8080/cafe-expansion/kakao-callback'
      });
    }
  </script>
  <style>
    body { background: #f5f5f5; color: #191919; font-family: 'Pretendard', sans-serif; }
    .kakao-box { max-width: 400px; margin: 80px auto; padding: 40px 20px; background: #fff; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); text-align: center; }
    .kakao-logo { height: 40px; margin-bottom: 24px; }
    .kakao-btn { background: none; border: none; padding: 0; margin: 0 auto; display: block; width: 100%; cursor: pointer; }
    .kakao-btn img { width: 100%; max-width: 320px; border-radius: 6px; }
    .desc { margin-top: 16px; color: #888; }
  </style>
</head>
<body>
  <jsp:include page="/WEB-INF/views/common/header.jsp"/>
  <div class="kakao-box">
    <img src="${pageContext.request.contextPath}/resources/image/Kakao_page_logo.jpg" alt="kakaopage" class="kakao-logo">
    <button type="button" class="kakao-btn" onclick="kakaoLogin()">
      <img src="${pageContext.request.contextPath}/resources/image/kakao_login_medium_wide.jpg" alt="카카오로 시작하기">
    </button>
    <div class="desc">
      <span>카카오 계정 하나로 로그인/회원가입이 모두 가능합니다.</span>
    </div>
  </div>
  <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
