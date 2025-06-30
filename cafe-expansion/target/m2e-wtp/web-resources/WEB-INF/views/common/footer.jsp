<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.footer-bar {
  width: 100%;
  background: #fff;
  border-top: 1px solid #eee;
  color: #888;
  text-align: center;
  padding: 24px 0 18px 0;
  font-size: 1rem;
  margin-top: 60px;
  letter-spacing: -0.5px;
}
.footer-bar a {
  color: #888;
  text-decoration: underline dotted;
  margin-left: 8px;
  font-size: 0.97rem;
}
.footer-bar a:hover {
  color: #f7b500;
}
</style>
<div class="footer-bar">
  <span>© 2025 카카오페이지 카피캣. All rights reserved.</span>
  <a href="${pageContext.request.contextPath}/about">회사소개</a>
  <a href="${pageContext.request.contextPath}/policy">이용약관</a>
  <a href="${pageContext.request.contextPath}/privacy">개인정보처리방침</a>
</div>
