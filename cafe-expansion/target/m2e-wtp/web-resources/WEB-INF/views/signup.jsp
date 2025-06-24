<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!-- [추가] JSTL core 태그 사용 -->

<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <style>
        /* (기존 스타일 생략 없이 그대로 유지) */
    </style>
</head>
<body>
    <!-- [추가] 회원가입 성공 시 팝업 -->
    <c:if test="${not empty msg}">
        <script>alert('회원가입이 완료되었습니다! 로그인 해주세요.');</script>
    </c:if>

    <h2>회원가입</h2>
    <!-- [수정] action에 컨텍스트 경로 적용 -->
    <form:form modelAttribute="user" method="post" action="<c:url value='/signup'/>">
        <div>
            <label>아이디:</label>
            <form:input path="username" />
            <form:errors path="username" />
        </div>
        <div>
            <label>비밀번호:</label>
            <form:password path="password" />
            <form:errors path="password" />
        </div>
        <div>
            <input type="submit" value="가입하기" />
        </div>
    </form:form>
</body>
</html>
