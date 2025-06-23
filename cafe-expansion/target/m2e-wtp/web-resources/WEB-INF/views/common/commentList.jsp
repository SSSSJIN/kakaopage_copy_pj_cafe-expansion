<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty comments}">
  <div class="mb-24pxr">
    <h4 class="font-medium2 text-el-60 mb-8pxr">댓글</h4>
    <ul class="space-y-8pxr">
      <c:forEach var="cmt" items="${comments}">
        <li class="p-12pxr bg-s-gray-20/15 rounded">
          <p class="font-medium1 text-el-60">
            ${cmt.writer}
            <span class="text-el-50">(${cmt.regDate})</span>
          </p>
          <p class="text-el-10">${cmt.content}</p>
        </li>
      </c:forEach>
    </ul>
  </div>
</c:if>
