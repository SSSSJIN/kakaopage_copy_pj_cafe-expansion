<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="container mx-auto px-122pxr">
  <h2 class="font-medium2 text-el-60 mb-16pxr">
    <c:choose>
      <c:when test="${board.id != null}">게시글 수정</c:when>
      <c:otherwise>새 게시글 작성</c:otherwise>
    </c:choose>
  </h2>
  <form action="<c:choose>
                   <c:when test='${board.id != null}'>
                     <c:url value='/boards/${board.id}/edit'/>
                   </c:when>
                   <c:otherwise>
                     <c:url value='/boards'/>
                   </c:otherwise>
                 </c:choose>"
        method="post"
        class="space-y-16pxr mb-32pxr">
    <input type="hidden" name="id" value="${board.id}"/>
    <div>
      <label class="block mb-8pxr">제목:
        <input type="text"
               name="title"
               value="${board.title}"
               class="w-full border p-8pxr rounded"/>
      </label>
    </div>
    <div>
      <label class="block mb-8pxr">작성자:
        <input type="text"
               name="writer"
               value="${board.writer}"
               class="w-1/3 border p-8pxr rounded"/>
      </label>
    </div>
    <div>
      <label class="block mb-8pxr">내용:</label>
      <textarea name="content"
                rows="10"
                class="w-full border p-8pxr rounded">${board.content}</textarea>
    </div>
    <div class="space-x-16pxr">
      <button type="submit"
              class="font-medium1 bg-el-bc text-white px-16pxr py-8pxr rounded">
        <c:choose>
          <c:when test="${board.id != null}">수정</c:when>
          <c:otherwise>등록</c:otherwise>
        </c:choose>
      </button>
      <a href="<c:url value='/boards'/>"
         class="font-medium1 text-el-60 underline">
        목록으로
      </a>
    </div>
  </form>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
