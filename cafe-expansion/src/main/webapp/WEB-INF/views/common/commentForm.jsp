<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="mb-32pxr">
  <h4 class="font-medium2 text-el-60 mb-8pxr">새 댓글 작성</h4>
  <form action="<c:url value='/boards/${board.id}/comments'/>"
        method="post"
        class="space-y-12pxr">
    <div>
      <label class="block mb-4pxr">
        작성자:
        <input type="text"
               name="writer"
               class="border p-8pxr rounded w-1/3"
               required />
      </label>
    </div>
    <div>
      <label class="block mb-4pxr">
        내용:
        <textarea name="content"
                  rows="3"
                  class="border p-8pxr rounded w-full"
                  required></textarea>
      </label>
    </div>
    <button type="submit"
            class="font-medium1 bg-el-bc text-white px-16pxr py-8pxr rounded">
      댓글 달기
    </button>
  </form>
</div>
