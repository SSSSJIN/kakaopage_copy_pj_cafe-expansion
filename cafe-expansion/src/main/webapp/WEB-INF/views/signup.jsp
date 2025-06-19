<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>회원가입</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="<c:url value='/signup'/>" method="post">
		<label>아이디: <input type="text" name="username"/></label><br/>
		<label>비밀번호: <input type="password" name="password"/></label><br/>
		<button type="submit">가입하기</button>
	</form>
</body>
</html>
