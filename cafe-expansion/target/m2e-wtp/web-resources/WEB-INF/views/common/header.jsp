<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  com.kakaopage.expansion.vo.UserVO user = (com.kakaopage.expansion.vo.UserVO) session.getAttribute("user");
%>
<style>
.header-bar { width: 100%; background: #fff; border-bottom: 1px solid #eee; box-shadow: 0 2px 8px rgba(0,0,0,0.03); font-family: 'Pretendard', 'Noto Sans KR', sans-serif; }
.header-inner { max-width: 1200px; margin: 0 auto; display: flex; align-items: center; justify-content: space-between; height: 68px; padding: 0 24px; }
.logo-area { display: flex; align-items: center; margin-right: 36px; }
.logo-img { height: 40px; margin-right: 12px; vertical-align: middle; }
.logo-text { font-size: 2rem; font-weight: bold; color: #191919; text-decoration: none; letter-spacing: -1px; font-family: 'Pretendard', 'Noto Sans KR', sans-serif; user-select: none; vertical-align: middle; }
.nav { display: flex; align-items: center; gap: 32px; }
.nav-link { color: #222 !important; text-decoration: none; font-size: 1.13rem; font-weight: 600; transition: color 0.2s; padding: 4px 0; }
.nav-link:hover { color: #f7b500 !important; border-bottom: 2px solid #f7b500; }
.right-area { display: flex; align-items: center; gap: 16px; }
.search-area { display: flex; align-items: center; background: #fafafa; border: 1px solid #eee; border-radius: 18px; padding: 0 12px 0 16px; height: 38px; margin-right: 12px; }
.search-input { width: 150px; border: none; background: transparent; font-size: 1rem; color: #222; outline: none; }
.search-btn { background: none; border: none; cursor: pointer; padding: 0 0 0 8px; display: flex; align-items: center; }
.search-btn img { width: 20px; height: 20px; }
.library-link { margin-right: 10px; margin-left: 10px; display: flex; align-items: center; }
.library-icon { width: 26px; height: 26px; cursor: pointer; transition: filter 0.15s; filter: grayscale(0); }
.library-icon:hover { filter: brightness(1.1) drop-shadow(0 0 4px #f7b50044); }
.user-area { display: flex; align-items: center; position: relative; }
.user-profile { width: 38px; height: 38px; border-radius: 50%; margin-left: 16px; cursor: pointer; border: 1px solid #eee; background: #fafafa; transition: box-shadow 0.2s; }
.user-profile:hover { box-shadow: 0 2px 8px rgba(0,0,0,0.08); }
.user-info-popover { display: none; position: absolute; top: 54px; right: 0; background: #fff; border: 1px solid #ddd; border-radius: 8px; box-shadow: 0 2px 16px rgba(0,0,0,0.08); padding: 20px 28px; min-width: 230px; z-index: 100; }
.user-area:hover .user-info-popover { display: block; }
.user-nickname { margin-left: 10px; font-weight: 500; }
.kakao-login-btn { margin-left: 20px; background: none; border: none; padding: 0; cursor: pointer; display: flex; align-items: center; }
.kakao-login-btn img { height: 40px; }
.user-info-popover { /* ... (팝업 스타일) ... */ }
.user-nickname-btn { background: none; border: none; font-size: 1.07rem; font-weight: 600; color: #222; cursor: pointer; padding: 0 12px; height: 38px; border-radius: 19px; transition: background 0.15s; }
.user-nickname-btn:hover { background: #f7f7f7; }
.logout-btn { background: #fff; color: #f00; border: 1px solid #eee; border-radius: 8px; padding: 8px 18px; font-size: 1rem; cursor: pointer; margin-top: 16px; width: 100%; transition: background 0.13s; }
.logout-btn:hover { background: #fff0f0; }
</style>

<div class="header-bar">
  <div class="header-inner">
    <a href="${pageContext.request.contextPath}/home" class="logo-area">
      <img src="https://page.kakaocdn.net/pageweb/2.29.6/public/images/img_logo_bi_text_l.svg" alt="kakaopage" class="logo-img" />
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
            <button type="button" class="user-nickname-btn" onclick="toggleInfo1Popup(event)">
              ${user.nickname}
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
              <img src="data:image/svg+xml,%3Csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M12.0009 2C9.23899 2 7 4.23898 7 7.00091C7 9.76285 9.23899 12.0018 12.0009 12.0018C14.7629 12.0018 17.0018 9.76285 17.0018 7.00091C17.0018 4.23898 14.7629 2 12.0009 2ZM8.5 7.00091C8.5 5.06741 10.0674 3.5 12.0009 3.5C13.9344 3.5 15.5018 5.06741 15.5018 7.00091C15.5018 8.93441 13.9344 10.5018 12.0009 10.5018C10.0674 10.5018 8.5 8.93441 8.5 7.00091Z' fill='%23222222'/%3E%3Cpath d='M8.75 14C5.02208 14 2 17.0221 2 20.75V21.9953H3.5V20.75C3.5 17.8505 5.85051 15.5 8.75 15.5H15.2527C18.1522 15.5 20.5027 17.8505 20.5027 20.75V21.9953H22.0027V20.75C22.0027 17.0221 18.9807 14 15.2527 14H8.75Z' fill='%23222222'/%3E%3C/svg%3E" alt="로그인" />
            </button>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
  </div>
</div>
