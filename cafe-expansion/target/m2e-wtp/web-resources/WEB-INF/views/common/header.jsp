<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- ✅ 다크 모드 헤더: 배경 #191919, 글자 흰색 -->
<header style="
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 20px 40px;
    background-color: #191919;
    color: #ffffff;
    border-bottom: 1px solid #333;
    font-family: 'Pretendard', sans-serif;
    font-size: 16px;
">
    <!-- 왼쪽: 로고 + 책 메뉴 -->
    <div style="display: flex; align-items: center; gap: 30px;">
        <a href="${pageContext.request.contextPath}/home" style="display: flex; align-items: center;">
            <img src="${pageContext.request.contextPath}/resources/image/cat.png"
                 alt="로고"
                 style="width: 120px; height: auto;">
        </a>
        <a href="${pageContext.request.contextPath}/book"
           style="text-decoration: none; color: #ffffff; font-weight: 500;">
            책
        </a>
    </div>

    <!-- 가운데: 검색 -->
    <div style="flex-grow: 1; text-align: center;">
        <form action="${pageContext.request.contextPath}/search" method="get" style="display: inline-block;">
            <input type="text" name="keyword"
                   placeholder="제목, 작가명으로 검색"
                   style="
                       width: 320px;
                       padding: 10px 15px;
                       border: 1px solid #555;
                       border-radius: 25px;
                       background-color: #333;
                       color: #fff;
                       font-size: 15px;
                   ">
            <button type="submit"
                    style="
                        margin-left: 8px;
                        padding: 10px 18px;
                        background-color: #ffeb00;
                        border: none;
                        border-radius: 25px;
                        font-weight: 600;
                        cursor: pointer;
                    ">
                검색
            </button>
        </form>
    </div>

    <!-- 오른쪽: 보관함 + 로그인/회원가입 또는 로그아웃 -->
    <div style="display: flex; align-items: center; gap: 20px;">
        <c:choose>
            <c:when test="${not empty sessionScope.loginUser}">
                <a href="${pageContext.request.contextPath}/collection"
                   style="text-decoration: none; color: #ffffff; font-weight: 400;">
                    보관함
                </a>
                <form action="${pageContext.request.contextPath}/logout" method="get" style="margin:0;">
                  <button type="submit" style="background:none;border:none;color:#fff;cursor:pointer;font-weight:400;">
                    로그아웃
                  </button>
                </form>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/collection"
                   style="text-decoration: none; color: #ffffff; font-weight: 400;">
                    보관함
                </a>
                <a href="${pageContext.request.contextPath}/login"
                   style="text-decoration: none; color: #ffffff; font-weight: 400;">
                    로그인
                </a>
                <a href="${pageContext.request.contextPath}/signup"
                   style="text-decoration: none; color: #ffffff; font-weight: 400;">
                    회원가입
                </a>
            </c:otherwise>
        </c:choose>
    </div>
</header>

<nav style="
    background-color: #191919;
    border-bottom: 1px solid #333;
">
    <div style="
        max-width: 1200px;
        margin: 0 auto;
        display: flex;
        align-items: center;
        gap: 30px;
        padding: 0 40px;
        height: 48px;
    ">
        <a href="${pageContext.request.contextPath}/hot"
           style="color: #ffffff; font-weight: 500; font-size: 16px; text-decoration: none; font-family: 'Pretendard', sans-serif;">
            지금 핫한
        </a>
        <a href="${pageContext.request.contextPath}/ranking"
           style="color: #ffffff; font-weight: 500; font-size: 16px; text-decoration: none; font-family: 'Pretendard', sans-serif;">
            실시간 랭킹
        </a>
        <a href="${pageContext.request.contextPath}/book"
           style="color: #ffffff; font-weight: 500; font-size: 16px; text-decoration: none; font-family: 'Pretendard', sans-serif;">
            책
        </a>
    </div>
</nav>
