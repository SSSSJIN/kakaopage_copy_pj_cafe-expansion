<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/views/admin/adminHeader.jsp" %>
<h2>이벤트 슬라이더 관리</h2>
<a href="/admin/event-slider/create">+ 새 배너 추가</a>
<table>
  <tr>
    <th>유형</th><th>제목</th><th>이미지</th><th>책</th><th>수정</th><th>삭제</th>
  </tr>
  <c:forEach var="slider" items="${sliders}">
    <tr>
      <td>${slider.type}</td>
      <td>${slider.title}</td>
      <td><img src="${slider.imageUrl}" width="100"></td>
      <td>
        <c:if test="${slider.bookId != null}">
          <a href="/detail?bookId=${slider.bookId}">책 상세</a>
        </c:if>
      </td>
      <td><a href="/admin/event-slider/edit/${slider.id}">수정</a></td>
      <td>
        <form action="/admin/event-slider/delete/${slider.id}" method="post" style="display:inline;">
          <button type="submit">삭제</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
