<%@ page language="java"
    pageEncoding="UTF-8"
    contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<footer>
  <div class="footer-container" style="text-align:center; padding:20px 0; background-color:#191919; color:#fff;">
    <p>&copy; 2025 카카오페이지 카피캣 프로젝트</p>
    <ul class="footer-links" style="list-style:none; margin:8px 0 0; padding:0; display:inline-flex; gap:16px;">
      <li><a href="${pageContext.request.contextPath}/home" style="color:#fff; text-decoration:none;">Home</a></li>
      <li><a href="${pageContext.request.contextPath}/book" style="color:#fff; text-decoration:none;">Books</a></li>
      <li><a href="${pageContext.request.contextPath}/hot" style="color:#fff; text-decoration:none;">Hot</a></li>
      <li><a href="${pageContext.request.contextPath}/ranking" style="color:#fff; text-decoration:none;">Ranking</a></li>
    </ul>
  </div>
</footer>
