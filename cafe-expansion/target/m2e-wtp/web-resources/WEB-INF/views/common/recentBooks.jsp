<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty recentBooks}">
  <h3>최근 본 책</h3>
  <div style="display:flex; gap:18px; flex-wrap:wrap;">
    <c:forEach var="book" items="${recentBooks}">
      <div style="width:120px; background:#fff; border-radius:8px; box-shadow:0 2px 8px rgba(0,0,0,0.06); padding:10px;">
        <img src="${book.image}" alt="${book.title}" style="width:100%; border-radius:4px;">
        <div style="margin-top:8px; font-weight:bold;">${book.title}</div>
        <div style="color:#555;">${book.author}</div>
      </div>
    </c:forEach>
  </div>
</c:if>
