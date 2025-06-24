<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!-- [추가] JSTL core 태그 사용 -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>페이지 로그인</title>
    <style>
        body { font-family: 'Malgun Gothic', Arial, sans-serif; background: #f8f8f8; }
        .login-container { width: 350px; margin: 80px auto; background: #fff; border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1); padding: 35px 30px; }
        .login-title { text-align: center; font-size: 1.8em; margin-bottom: 30px; color: #333; }
        .form-group { margin-bottom: 18px; }
        label { display: block; margin-bottom: 5px; color: #555; }
        input[type="text"], input[type="password"] {
            width: 100%; padding: 9px 10px; border: 1px solid #ddd; border-radius: 5px; font-size: 1em;
        }
        .login-btn {
            width: 100%; padding: 10px 0; background: #ffeb00; border: none; border-radius: 5px;
            font-size: 1em; font-weight: bold; cursor: pointer;
        }
        .login-btn:hover { background: #ffe400; }
        .signup-link { text-align: right; margin-top: 15px; }
        .signup-link a { color: #3a1d1d; text-decoration: underline; }
    </style>
</head>
<body>
    <!-- [추가] flash 메시지 팝업 -->
    <c:if test="${not empty msg}">
        <script>
            <c:choose>
                <c:when test="${msg=='NOT_REGISTERED'}">
                    alert('회원가입이 필요합니다!');
                </c:when>
                <c:when test="${msg=='WRONG_PW'}">
                    alert('비밀번호가 일치하지 않습니다!');
                </c:when>
                <c:when test="${msg=='SIGNUP_OK'}">
                    alert('회원가입이 완료되었습니다! 로그인 해주세요.');
                </c:when>
            </c:choose>
        </script>
    </c:if>

    <div class="login-container">
        <div class="login-title">페이지 로그인</div>
        <!-- [수정] action에 컨텍스트 경로 적용 -->
        <form action="<c:url value='/login'/>" method="post">
            <div class="form-group">
                <label for="username">아이디</label>
                <input type="text" id="username" name="username" placeholder="아이디 입력" required />
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" placeholder="비밀번호 입력" required />
            </div>
            <button type="submit" class="login-btn">로그인</button>
        </form>

        <div class="signup-link">
            <!-- [수정] 컨텍스트 경로 적용 -->
            <a href="<c:url value='/signup'/>">회원가입</a>
        </div>
    </div>
</body>
</html>
