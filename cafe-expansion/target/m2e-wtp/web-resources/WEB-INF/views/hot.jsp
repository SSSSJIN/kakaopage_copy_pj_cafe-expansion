<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<h2>지금 핫한 책</h2>
<div>
  <c:forEach var="book" items="${hotBooks}">
    <div>${book.title}</div>
  </c:forEach>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
