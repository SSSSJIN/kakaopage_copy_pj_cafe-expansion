<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div style="max-width:900px; margin:40px auto;">
  <h2>실시간 랭킹</h2>
  <div style="display:flex; gap:24px; flex-wrap:wrap;">
    <c:forEach var="book" items="${rankingBooks}">
      <div style="width:160px; text-align:center;">
        <a href="${pageContext.request.contextPath}/detail?bookId=${book.id}">
          <img src="${pageContext.request.contextPath}/resources/image/${book.image}" 
            alt="${book.title}"
            style="width:100%; border-radius:8px;"
            onerror="this.onerror=null;this.src='${pageContext.request.contextPath}/resources/image/book_default.jpg';"
          />
        </a>
        <div style="margin-top:8px;">${book.title}</div>
      </div>
    </c:forEach>
  </div>

  <h2 style="margin-top:48px;">지금 핫한 작품</h2>
  <div style="display:flex; gap:24px; flex-wrap:wrap;">
    <c:forEach var="book" items="${hotBooks}">
      <div style="width:160px; text-align:center;">
        <a href="${pageContext.request.contextPath}/detail?bookId=${book.id}">
          <img src="${pageContext.request.contextPath}/resources/image/${book.image}" 
            alt="${book.title}"
            style="width:100%; border-radius:8px;"
            onerror="this.onerror=null;this.src='${pageContext.request.contextPath}/resources/image/book_default.jpg';"
          />
        </a>
        <div style="margin-top:8px;">${book.title}</div>
      </div>
    </c:forEach>
  </div>

  <c:if test="${not empty user and not empty recentBooks}">
    <h2 style="margin-top:48px;">최근 본 목록</h2>
    <div style="display:flex; gap:24px; flex-wrap:wrap;">
      <c:forEach var="book" items="${recentBooks}">
        <div style="width:140px; text-align:center;">
          <a href="${pageContext.request.contextPath}/detail?bookId=${book.id}">
            <img src="${pageContext.request.contextPath}/resources/image/${book.image}" 
              alt="${book.title}"
              style="width:100%; border-radius:8px;"
              onerror="this.onerror=null;this.src='${pageContext.request.contextPath}/resources/image/book_default.jpg';"
            />
          </a>
          <div style="margin-top:8px;">${book.title}</div>
        </div>
      </c:forEach>
    </div>
  </c:if>
</div>

<script>
  (function() {
    const slides = document.querySelectorAll('.event-slider .slide');
    const slider = document.querySelector('.event-slider');
    const prevBtn = document.querySelector('.slider-btn.prev');
    const nextBtn = document.querySelector('.slider-btn.next');
    const slideWidth = 196; // 이미지 180 + 간격 16
    let currentIdx = 0;
    let timer = null;

    function updateSlider() {
      if(slider) slider.style.transform = `translateX(-${currentIdx * slideWidth}px)`;
    }

    if(prevBtn) {
      prevBtn.onclick = () => {
        currentIdx = currentIdx > 0 ? currentIdx -1 : slides.length -1;
        updateSlider();
        resetTimer();
      };
    }

    if(nextBtn) {
      nextBtn.onclick = () => {
        currentIdx = currentIdx < slides.length -1 ? currentIdx + 1 : 0;
        updateSlider();
        resetTimer();
      };
    }

    function autoSlide() {
      currentIdx = (currentIdx +1) % slides.length;
      updateSlider();
    }

    function resetTimer() {
      if(timer) clearInterval(timer);
      timer = setInterval(autoSlide, 2000);
    }

    updateSlider();
    timer = setInterval(autoSlide, 2000);

  })();
</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
