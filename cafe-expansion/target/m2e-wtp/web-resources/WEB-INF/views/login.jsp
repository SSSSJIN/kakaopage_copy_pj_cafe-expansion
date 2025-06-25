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
  </style>
</head>
<body>
  <!-- 로그인 박스만 중앙에 띄우는 래퍼 -->
  <div class="login-page">
    <div class="login-box">
      <h1>kakao</h1>

      <input type="text" id="id" placeholder="카카오메일 아이디, 이메일, 전화번호"/>
      <input type="password" id="pw" placeholder="비밀번호"/>

      <label class="option">
        <input type="checkbox" id="auto"/> 간편로그인 정보 저장
      </label>

      <button class="btn-login" onclick="doLogin()">로그인</button>

      <div class="or">또는</div>
      <button class="btn-qr">QR코드 로그인</button>

      <div class="links">
        <a href="${pageContext.request.contextPath}/signup">회원가입</a>
        <a href="#">계정 찾기</a>
        <a href="#">비밀번호 찾기</a>
      </div>
    </div>
  </div>

  <!-- 푸터는 래퍼 밖, body 아래에 그대로 -->
  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

  <script>
    async function doLogin() {
      const id = document.getElementById('id').value.trim();
      const pw = document.getElementById('pw').value;
      try {
        const resp = await fetch(
          '${pageContext.request.contextPath}/api/auth/login', {
            method: 'POST',
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify({id, pw})
          }
        );
        const result = await resp.json();
        if (resp.ok && result.success) {
          window.location.href = '${pageContext.request.contextPath}/home';
        } else {
          alert(result.message || '로그인 실패');
        }
      } catch(err) {
        console.error(err);
        alert('서버 통신 중 오류가 발생했습니다.');
      }
    }
  </script>
</body>
</html>
