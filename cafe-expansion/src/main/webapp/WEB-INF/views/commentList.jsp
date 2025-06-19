<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty comments}">
  <h4>댓글</h4>
  <ul>
    <c:forEach var="cmt" items="${comments}">
      <li>
        <strong>${cmt.writer}</strong> 
        (${cmt.regDate}):
        ${cmt.content}
      </li>
    </c:forEach>
  </ul>
</c:if>
