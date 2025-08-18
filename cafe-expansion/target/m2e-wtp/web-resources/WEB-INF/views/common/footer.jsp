<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 이전의 <style> 태그와 그 내용은 style.css 파일로 옮겨졌으므로 여기서는 제거합니다. --%>

<div class="footer-bar">
  <span>© 2025 카카오페이지 카피캣. All rights reserved.</span>
  <a href="${pageContext.request.contextPath}/about">회사소개</a>
  <a href="${pageContext.request.contextPath}/policy">이용약관</a>
  <a href="${pageContext.request.contextPath}/privacy">개인정보처리방침</a>
</div>

<%--
  주의: </body>와 </html> 태그는 footer.jsp를 include하는 메인 JSP 파일 (예: detail.jsp, home.jsp 등)의 맨 마지막에 위치해야 합니다.
  footer.jsp 자체에는 이 태그들이 일반적으로 포함되지 않습니다.
--%>