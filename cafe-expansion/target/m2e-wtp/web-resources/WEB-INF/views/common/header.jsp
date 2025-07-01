<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  com.kakaopage.expansion.vo.UserVO user = (com.kakaopage.expansion.vo.UserVO) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>카카오페이지 확장</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pretendard.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/62b5eaaa32983221.css">

    <c:if test="${empty user}">
      <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
      <script>
        Kakao.init('a43481684e7ca266c31cb57d5ffed16f');
        function kakaoLogin() {
          Kakao.Auth.authorize({
            redirectUri: 'http://localhost:8080/cafe-expansion/kakao-callback'
          });
        }
      </script>
    </c:if>
</head>
<body>

<div class="header-bar">
  <div class="header-inner">
    <a href="${pageContext.request.contextPath}/home" class="logo-area">
      <span style="font-size:2rem;font-weight:bold;color:#222;">kakaopage</span>
    </a>
    <div class="nav">
      <a href="${pageContext.request.contextPath}/home" class="nav-link">지금 핫한</a>
      <a href="${pageContext.request.contextPath}/ranking" class="nav-link">실시간 랭킹</a>
      <a href="${pageContext.request.contextPath}/books" class="nav-link">책</a>
    </div>
    <div class="right-area">
      <form class="search-area" action="${pageContext.request.contextPath}/search" method="get">
        <input type="text" name="q" class="search-input" placeholder="작품, 작가 검색" autocomplete="off" />
        <button type="submit" class="search-btn">
          <img src="data:image/svg+xml,%3Csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M15.1991 6.74703C12.865 4.4131 9.08077 4.4131 6.74668 6.74703C4.41256 9.08098 4.41256 12.8651 6.74668 15.199C8.90131 17.3535 12.2917 17.5192 14.6364 15.696L17.9384 18.9978L18.999 17.9371L15.6969 14.6353C17.5194 12.2908 17.3535 8.90121 15.1991 6.74703ZM7.8073 7.80772C9.55561 6.05953 12.3902 6.05953 14.1385 7.80772C15.8868 9.55588 15.8868 12.3902 14.1385 14.1383C12.3902 15.8865 9.55561 15.8865 7.8073 14.1383C6.05902 12.3902 6.05902 9.55588 7.8073 7.80772Z' fill='%23222222'/%3E%3C/svg%3E" alt="검색" />
        </button>
      </form>
      <a href="${pageContext.request.contextPath}/library" class="library-link" title="보관함">
        <img src="data:image/svg+xml,%3Csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M20 2H4V3.5H20V2ZM3 6C2.44772 6 2 6.44772 2 7V19C2 20.6569 3.34315 22 5 22H19C20.6569 22 22 20.6569 22 19V7C22 6.44772 21.5523 6 21 6H3ZM20.5 7.5H3.5V19C3.5 19.8284 4.17157 20.5 5 20.5H19C19.8284 20.5 20.5 19.8284 20.5 19V7.5ZM9 11H15V12.5H9V11Z' fill='%23222222'/%3E%3C/svg%3E" alt="보관함" class="library-icon" />
      </a>
      <div class="user-area">
        <c:choose>
          <c:when test="${not empty user}">
            <button type="button" class="kakao-login-btn" onclick="toggleInfo1Popup(event)" style="display:flex;align-items:center;gap:2px;">
              <img src="data:image/svg+xml,%3csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M12.0009 2C9.23899 2 7 4.23898 7 7.00091C7 9.76285 9.23899 12.0018 12.0009 12.0018C14.7629 12.0018 17.0018 9.76285 17.0018 7.00091C17.0018 4.23898 14.7629 2 12.0009 2ZM8.5 7.00091C8.5 5.06741 10.0674 3.5 12.0009 3.5C13.9344 3.5 15.5018 5.06741 15.5018 7.00091C15.5018 8.93441 13.9344 10.5018 12.0009 10.5018C10.0674 10.5018 8.5 8.93441 8.5 7.00091Z' fill='%23222222'/%3e %3cpath d='M8.75 14C5.02208 14 2 17.0221 2 20.75V21.9953H3.5V20.75C3.5 17.8505 5.85051 15.5 8.75 15.5H15.2527C18.1522 15.5 20.5027 17.8505 20.5027 20.75V21.9953H22.0027V20.75C22.0027 17.0221 18.9807 14 15.2527 14H8.75Z' fill='%23222222'/%3e %3c/svg%3e" alt="로그인" style="height:40px;">
              <img src="data:image/svg+xml,%3csvg width='12' height='12' viewBox='0 0 12 12' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M3.04482 3.5L6 6.42893L8.95518 3.5L10 4.53553L6 8.5L2 4.53553L3.04482 3.5Z' fill='%23222222'/%3e %3c/svg%3e" alt="아래화살표" style="height:18px;">
            </button>
            <div id="info1-popup" class="user-info-popover" style="display:none;">
              <a href="${pageContext.request.contextPath}/account" class="user-nickname-btn" style="display:block;text-align:center;font-weight:bold;">
                ${user.nickname} <span style="font-size:0.95em;color:#888;">회원정보</span>
              </a>
              <a href="${pageContext.request.contextPath}/logout" class="logout-btn">로그아웃</a>
            </div>
            <script>
              function toggleInfo1Popup(e) {
                e.stopPropagation();
                var info1 = document.getElementById('info1-popup');
                info1.style.display = (info1.style.display === 'block') ? 'none' : 'block';
              }
              document.addEventListener('click', function(e) {
                var info1 = document.getElementById('info1-popup');
                if (!e.target.closest('.user-area')) {
                  if(info1) info1.style.display = 'none';
                }
              });
            </script>
          </c:when>
          <c:otherwise>
            <button type="button" class="kakao-login-btn" onclick="kakaoLogin()">
              <img src="data:image/svg+xml,%3csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M12.0009 2C9.23899 2 7 4.23898 7 7.00091C7 9.76285 9.23899 12.0018 12.0009 12.0018C14.7629 12.0018 17.0018 9.76285 17.0018 7.00091C17.0018 4.23898 14.7629 2 12.0009 2ZM8.5 7.00091C8.5 5.06741 10.0674 3.5 12.0009 3.5C13.9344 3.5 15.5018 5.06741 15.5018 7.00091C15.5018 8.93441 13.9344 10.5018 12.0009 10.5018C10.0674 10.5018 8.5 8.93441 8.5 7.00091Z' fill='%23222222'/%3e %3cpath d='M8.75 14C5.02208 14 2 17.0221 2 20.75V21.9953H3.5V20.75C3.5 17.8505 5.85051 15.5 8.75 15.5H15.2527C18.1522 15.5 20.5027 17.8505 20.5027 20.75V21.9953H22.0027V20.75C22.0027 17.0221 18.9807 14 15.2527 14H8.75Z' fill='%23222222'/%3e %3c/svg%3e" alt="로그인" style="height:40px;">
            </button>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
  </div>
</div>
