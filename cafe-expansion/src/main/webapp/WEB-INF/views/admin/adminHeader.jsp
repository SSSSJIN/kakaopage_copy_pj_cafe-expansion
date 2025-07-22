<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    com.kakaopage.expansion.vo.UserVO user = (com.kakaopage.expansion.vo.UserVO) session.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>관리자 | kakaopage</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    <style>
        .admin-nav-bar {
            background: #222;
            color: #fff;
            padding: 12px 0;
            font-size: 1.05rem;
            text-align: center;
        }
        .admin-nav-link {
            color: #fff !important;
            text-decoration: none;
            margin: 0 16px;
            font-weight: 600;
            padding: 3px 8px;
            transition: background 0.1s;
        }
        .admin-nav-link:hover {
            background: #fee500;
            color: #222 !important;
            border-radius: 6px;
        }
        .admin-header-bar {
            width: 100%;
            background: #fff;
            color: #191919;
            padding: 22px 0 10px 0;
            border-bottom: 1px solid #eee;
        }
        .admin-header-inner  {
            max-width: 1050px;
            margin: 0 auto;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 0 24px;
        }
        .admin-logo {
            font-size: 2rem;
            font-weight: bold;
            color: #191919;
            text-decoration: none;
        }
        .admin-user-info {
            font-size: 1.07rem;
            color: #888;
        }
    </style>
</head>
<body>
    <!-- 관리자 헤더 -->
    <div class="admin-header-bar">
        <div class="admin-header-inner">
            <a href="${pageContext.request.contextPath}/admin" class="admin-logo">kakaopage 관리자</a>
            <div class="admin-user-info">
                <c:if test="${user != null}">
                    관리자: <span class="admin-user-nickname" style="font-weight:600">${user.nickname}</span>
                    (<a href="${pageContext.request.contextPath}/logout" style="color:#f00;">로그아웃</a>)
                </c:if>
            </div>
        </div>
    </div>
    <!-- 관리자 네비 -->
    <div class="admin-nav-bar">
        <a class="admin-nav-link" href="${pageContext.request.contextPath}/admin">홈</a>
        <a class="admin-nav-link" href="${pageContext.request.contextPath}/admin/manager">관리자 관리</a>
        <a class="admin-nav-link" href="${pageContext.request.contextPath}/admin/event-slider">이벤트 슬라이더 관리</a>
        <!-- 필요시 추가 메뉴
        <a class="admin-nav-link" href="${pageContext.request.contextPath}/admin/board">게시판 관리</a>
        <a class="admin-nav-link" href="#">작품 관리</a>
        <a class="admin-nav-link" href="#">중간관리자 관리</a>
        <a class="admin-nav-link" href="#">시스템 설정</a>
        -->
    </div>
</body>
</html>
