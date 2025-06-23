<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jsp" %>

<h2>회원가입</h2>
<form:form method="post" action="${pageContext.request.contextPath}/signup" modelAttribute="user">
  <div>
    <form:label path="username">아이디:</form:label>
    <form:input path="username"/>
    <form:errors path="username" cssClass="error"/>
  </div>
  <div>
    <form:label path="password">비밀번호:</form:label>
    <form:password path="password"/>
    <form:errors path="password" cssClass="error"/>
  </div>
  <button type="submit">가입하기</button>
</form:form>

<%@ include file="common/footer.jsp" %>
