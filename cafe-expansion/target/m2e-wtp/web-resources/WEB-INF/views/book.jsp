<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<h2>전체 책 목록</h2>
<div id="bookList">
  <c:forEach var="book" items="${books}">
    <div class="book-item">
      <h3>${book.title}</h3>
      <!-- 만약 author, thumbnail 등이 있다면 추가로 표시 가능 -->
    </div>
  </c:forEach>
</div>

<hr/>

<h2>🔍 카카오 API 검색</h2>
<input type="text" id="searchBox" placeholder="검색어 입력…"/>
<button type="button" id="searchBtn">검색</button>

<div id="searchResults"></div>

<script>
  // 검색 버튼 클릭 시 AJAX 호출
  document.getElementById('searchBtn').addEventListener('click', async function() {
    const query = document.getElementById('searchBox').value.trim();
    if (!query) {
      alert('검색어를 입력하세요.');
      return;
    }
    try {
      // contextPath를 붙여서 올바른 URL 호출
      const resp = await fetch(
        '${pageContext.request.contextPath}/api/book/search?q='
        + encodeURIComponent(query)
      );
      if (!resp.ok) {
        throw new Error('HTTP ' + resp.status);
      }
      const data = await resp.json();

      const container = document.getElementById('searchResults');
      container.innerHTML = '<h3>검색 결과</h3>';

      if (!data.documents || data.documents.length === 0) {
        container.innerHTML += '<p>결과가 없습니다.</p>';
        return;
      }

      // 문서마다 카드 생성
      data.documents.forEach(item => {
        const div = document.createElement('div');
        div.className = 'book-item';
        div.innerHTML = `
          <h4>${item.title.replace(/<[^>]+>/g, '')}</h4>
          ${item.thumbnail ? `<img src="${item.thumbnail}" alt="표지"/>` : ''}
          <p>${item.address_name || ''}</p>
        `;
        container.appendChild(div);
      });
    } catch (err) {
      console.error(err);
      alert('검색 중 오류 발생: ' + err.message);
    }
  });
</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
