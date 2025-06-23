<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="container mx-auto px-122pxr">
  <h2 class="font-medium2 text-el-60 mb-16pxr">게시판 목록</h2>
  <p class="mb-24pxr">
    <a href="<c:url value='/boards/new'/>"
       class="font-medium1 cursor-pointer text-el-60">
      새 글 작성
    </a>
  </p>
  <table class="w-full text-el-10 mb-32pxr">
    <thead>
      <tr class="bg-s-gray-20/15">
        <th class="p-8pxr">번호</th>
        <th class="p-8pxr">제목</th>
        <th class="p-8pxr">작성자</th>
        <th class="p-8pxr">등록일</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="b" items="${boards}">
        <tr class="hover:bg-s-gray-20 cursor-pointer">
          <td class="p-8pxr">${b.id}</td>
          <td class="p-8pxr">
            <a href="<c:url value='/boards/${b.id}'/>"
               class="text-el-50 hover:text-el-bc">
              ${b.title}
            </a>
          </td>
          <td class="p-8pxr">${b.writer}</td>
          <td class="p-8pxr">${b.regDate}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
