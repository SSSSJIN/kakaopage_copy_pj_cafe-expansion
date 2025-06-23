<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="container mx-auto px-122pxr">
  <!-- 게시글 제목/메타 -->
  <h2 class="font-medium2 text-el-60 mb-16pxr">${board.title}</h2>
  <p class="text-el-50 mb-16pxr">
    작성자: ${board.writer} | 등록일: ${board.regDate}
  </p>

  <!-- 게시글 내용 -->
  <div class="rounded-8pxr bg-s-gray-20/15 p-16pxr mb-24pxr">
    ${board.content}
  </div>

  <!-- 수정·삭제·목록 -->
  <div class="flex items-center space-x-16pxr mb-32pxr">
    <a href="<c:url value='/boards/${board.id}/edit'/>"
       class="font-medium1 cursor-pointer text-el-60">
      수정
    </a>
    <form action="<c:url value='/boards/${board.id}/delete'/>"
          method="post"
          style="display:inline">
      <button type="submit"
              class="font-medium1 cursor-pointer text-el-60"
              onclick="return confirm('정말 삭제하시겠습니까?')">
        삭제
      </button>
    </form>
    <a href="<c:url value='/boards'/>"
       class="font-medium1 cursor-pointer text-el-60">
      목록으로
    </a>
  </div>

  <!-- 댓글 목록/작성 폼 -->
  <jsp:include page="commentList.jsp">
    <jsp:param name="comments" value="${comments}" />
  </jsp:include>
  <jsp:include page="commentForm.jsp">
    <jsp:param name="board.id" value="${board.id}" />
  </jsp:include>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
