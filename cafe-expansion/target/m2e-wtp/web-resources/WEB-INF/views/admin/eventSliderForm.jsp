<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/views/admin/adminHeader.jsp" %>
<h2>이벤트/책 배너 ${slider.id == null ? '등록' : '수정'}</h2>
<form action="${slider.id == null ? '/admin/event-slider/create' : '/admin/event-slider/edit/' + slider.id}" method="post">
  <label>유형:
    <select name="type">
      <option value="EVENT" ${slider.type == 'EVENT' ? 'selected' : ''}>이벤트</option>
      <option value="BOOK" ${slider.type == 'BOOK' ? 'selected' : ''}>책</option>
    </select>
  </label><br>
  <label>제목: <input type="text" name="title" value="${slider.title}"></label><br>
  <label>이미지 URL: <input type="text" name="imageUrl" value="${slider.imageUrl}"></label><br>
  <label>링크 URL: <input type="text" name="linkUrl" value="${slider.linkUrl}"></label><br>
  <label>설명: <textarea name="description">${slider.description}</textarea></label><br>
  <label>책 선택(BOOK 유형만):
    <select name="bookId">
      <option value="">선택안함</option>
      <c:forEach var="book" items="${books}">
        <option value="${book.id}" ${slider.bookId == book.id ? 'selected' : ''}>${book.title}</option>
      </c:forEach>
    </select>
  </label><br>
  <label>시작일: <input type="date" name="startDate" value="${slider.startDate}"></label><br>
  <label>종료일: <input type="date" name="endDate" value="${slider.endDate}"></label><br>
  <button type="submit">저장</button>
</form>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
