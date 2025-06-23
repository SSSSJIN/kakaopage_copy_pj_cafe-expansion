<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>회원가입</title>
</head>
<body>
	<h2>회원가입</h2>
	<form:form modelAttribute="user" method="post">
		<div>
			<label>아이디:</label>
			<form:input path="username" />
			<form:errors path="username"/>
		</div>
		<div>
			<label>비밀번호:</label>
			<form:password path="password" />
			<form:errors path="password"/>
		</div>
		<div>
			<input type="submit" value="가입하기" />
		</div>
	</form:form>
</body>
</html>
