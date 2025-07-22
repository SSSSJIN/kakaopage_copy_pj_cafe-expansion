<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/views/admin/adminHeader.jsp" %>
<h2>중간관리자(작가) 목록</h2>
<a href="/admin/manager/register">+ 중간관리자 등록</a>
<table>
  <tr>
    <th>이름</th><th>이메일</th><th>담당 작품</th><th>해제</th>
  </tr>
  <c:forEach var="manager" items="${managers}">
    <tr>
      <td>${manager.username}</td>
      <td>${manager.email}</td>
      <td>
        <c:forEach var="work" items="${manager.works}">
          ${work.bookTitle}<br/>
        </c:forEach>
      </td>
      <td>
        <form action="/admin/manager/revoke" method="post">
          <input type="hidden" name="managerId" value="${manager.id}">
          <button type="submit">권한 해제</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
