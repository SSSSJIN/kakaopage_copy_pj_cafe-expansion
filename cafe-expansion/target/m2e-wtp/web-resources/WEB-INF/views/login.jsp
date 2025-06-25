<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <title>kakao 로그인</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
  <style>
    /* 페이지 기본 설정 */
    body {
      margin: 0;
      padding: 0;
      background-color: #f5f5f5;
      font-family: 'Pretendard', sans-serif;
    }
    /* 로그인 박스만 중앙 정렬하는 래퍼 */
    .login-page {
      display: flex;
      justify-content: center;
      align-items: center;
      height: calc(100vh - 200px); /* 푸터 높이(약 200px)를 뺀 영역 */
    }
    /* 로그인 박스 */
    .login-box {
      background-color: #fff;
      width: 380px;
      padding: 32px;
      border-radius: 12px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.1);
      text-align: center;
      color: #191919;
    }
    .login-box h1 {
      font-size: 32px;
      margin-bottom: 32px;
      font-weight: bold;
      letter-spacing: -1px;
    }
    .login-box input {
      width: 100%;
      border: none;
      border-bottom: 1px solid #e4e4e4;
      padding: 12px 0;
      margin-bottom: 24px;
      font-size: 16px;
      color: #333;
      background: none;
      outline: none;
      box-sizing: border-box;
    }
    .login-box .option {
      display: flex;
      align-items: center;
      margin-bottom: 32px;
      font-size: 14px;
      color: #555;
      cursor: pointer;
    }
    .login-box .option input {
      margin-right: 8px;
      width: 16px; height: 16px;
    }
    .login-box .btn-login {
      width: 100%;
      padding: 14px 0;
      background-color: #ffeb00;
      border: none;
      border-radius: 4px;
      font-size: 16px;
      font-weight: bold;
      cursor: pointer;
      margin-bottom: 16px;
    }
    .login-box .or {
      position: relative;
      font-size: 14px;
      color: #ccc;
      margin-bottom: 16px;
    }
    .login-box .or::before,
    .login-box .or::after {
      content: '';
      position: absolute;
      top: 50%;
      width: 40%;
      height: 1px;
      background: #e4e4e4;
    }
    .login-box .or::before { left: 0; }
    .login-box .or::after  { right: 0; }
    .login-box .btn-qr {
      width: 100%;
      padding: 14px 0;
      background-color: #f5f5f5;
      border: none;
      border-radius: 4px;
      font-size: 16px;
      cursor: pointer;
      margin-bottom: 32px;
      color: #333;
    }
    .login-box .links {
      display: flex;
      justify-content: space-between;
      font-size: 14px;
    }
    .login-box .links a {
      color: #191919;
      text-decoration: none;
    }
    .error-msg {
      color: #d32f2f;
      margin-bottom: 16px;
      font-size: 14px;
    }
  </style>
</head>
<body>
  <div class="login-page">
    <div class="login-box">
      <h1>kakao</h1>

      <!-- (1) form 태그로 변경 -->
      <form action="${pageContext.request.contextPath}/login" method="post" style="display:flex;flex-direction:column;">
        <input name="username" type="text" placeholder="카카오메일 아이디, 이메일, 전화번호" required/>
        <input name="password" type="password" placeholder="비밀번호" required/>

        <label class="option">
          <input type="checkbox" name="rememberMe"/> 간편로그인 정보 저장
        </label>

        <!-- (2) 버튼도 submit -->
        <button type="submit" class="btn-login">로그인</button>
      </form>

      <c:if test="${not empty param.error}">
        <div class="error-msg">아이디 또는 비밀번호가 올바르지 않습니다.</div>
      </c:if>

      <div class="or">또는</div>
      <button class="btn-qr" onclick="alert('QR 로그인은 추후 구현 예정입니다')">QR코드 로그인</button>

      <div class="links">
        <a href="${pageContext.request.contextPath}/signup">회원가입</a>
        <a href="#">계정 찾기</a>
        <a href="#">비밀번호 찾기</a>
      </div>
    </div>
  </div>

  <!-- 푸터 포함 -->
  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>
