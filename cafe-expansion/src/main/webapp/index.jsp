<%@ page contentType="text/html; charset=UTF-8" %>
<%
  response.sendRedirect(request.getContextPath() + "/home");
%>
<%-- 자동으로 /home 컨트롤러로 포워드 --%>
<jsp:forward page="/home" />
