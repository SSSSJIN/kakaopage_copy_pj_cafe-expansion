<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <title>회원가입 | 카카오페이지 카피캣</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body style="background-color:#f5f5f5;">

  <div style="
      max-width:400px;
      margin:80px auto;
      padding:40px 20px;
      background-color:#ffffff;
      border-radius:8px;
      box-shadow:0 2px 8px rgba(0,0,0,0.1);
      text-align:center;
      font-family:'Pretendard', sans-serif;
  ">
    <h1 style="margin:0 0 24px; font-size:28px; color:#191919;">kakao</h1>
    <form action="${pageContext.request.contextPath}/signup" method="post" style="display:flex; flex-direction:column; gap:12px;">
      <input name="username" type="text" placeholder="이메일 또는 사용자명" required
             style="padding:10px; border:1px solid #ccc; border-radius:4px;"/>
      <input name="password" type="password" placeholder="비밀번호" required
             style="padding:10px; border:1px solid #ccc; border-radius:4px;"/>
      <button type="submit"
              style="padding:12px; background:#fee500; border:none; border-radius:4px; font-weight:600;">
        가입하기
      </button>
    </form>
  </div>

  <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
