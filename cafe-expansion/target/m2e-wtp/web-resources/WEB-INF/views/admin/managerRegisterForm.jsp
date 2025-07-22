<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/views/admin/adminHeader.jsp" %>
<h2>중간관리자(작가) 등록</h2>
<form action="/admin/manager/register" method="post">
  <label>유저:
    <select name="userId">
      <c:forEach var="user" items="${users}">
        <option value="${user.id}">${user.username} (${user.email})</option>
      </c:forEach>
    </select>
  </label><br>
  <label>담당 작품:
    <select name="bookId">
      <c:forEach var="book" items="${books}">
        <option value="${book.id}">${book.title}</option>
      </c:forEach>
    </select>
  </label><br>
  <button type="submit">등록</button>
</form>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
