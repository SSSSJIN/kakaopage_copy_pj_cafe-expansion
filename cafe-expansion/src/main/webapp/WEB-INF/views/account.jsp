<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  com.kakaopage.expansion.vo.UserVO user = (com.kakaopage.expansion.vo.UserVO) session.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <title>계정 정보 | 카카오페이지 카피캣</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
  <style>
    .account-info-box {
      max-width: 480px;
      margin: 60px auto 0 auto;
      background: #fff;
      border-radius: 14px;
      box-shadow: 0 2px 12px rgba(0,0,0,0.07);
      padding: 38px 32px 32px 32px;
      text-align: left;
    }
    .account-info-box h2 {
      font-size: 1.3rem;
      font-weight: bold;
      margin-bottom: 28px;
      letter-spacing: -1px;
    }
    .account-table {
      width: 100%;
      font-size: 1.08rem;
      color: #222;
      margin-bottom: 28px;
      border-collapse: collapse;
    }
    .account-table td {
      padding: 12px 0 12px 0;
      vertical-align: top;
    }
    .account-table td:first-child {
      width: 110px;
      color: #888;
      font-weight: 500;
    }
    .withdraw-btn {
      background: #fff;
      color: #f00;
      border: 1px solid #eee;
      border-radius: 8px;
      padding: 10px 24px;
      font-size: 1.03rem;
      cursor: pointer;
      width: 100%;
      transition: background 0.13s;
      margin-top: 10px;
    }
    .withdraw-btn:hover {
      background: #fff0f0;
    }
  </style>
</head>
<body>
  <jsp:include page="/WEB-INF/views/common/header.jsp"/>
  <div class="account-info-box">
    <h2>계정 정보</h2>
    <table class="account-table">
      <tr>
        <td>닉네임</td>
        <td>${user.nickname}</td>
      </tr>
      <tr>
        <td>회원번호</td>
        <td>${user.kakaoId}</td>
      </tr>
      <tr>
        <td>카카오계정</td>
        <td>${user.email}</td>
      </tr>
    </table>
    <form action="${pageContext.request.contextPath}/withdraw" method="post">
      <button type="submit" class="withdraw-btn" onclick="return confirm('정말 서비스 탈퇴하시겠습니까?')">서비스 탈퇴</button>
    </form>
  </div>
  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>
