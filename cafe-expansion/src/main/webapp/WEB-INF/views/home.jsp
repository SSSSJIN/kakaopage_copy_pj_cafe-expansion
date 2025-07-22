<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <title>카카오페이지 카피캣 - 홈</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body style="background-color:#f5f5f5;">

  <!-- [변경] 이벤트 슬라이더 영역 추가 -->
  <div class="event-slider-container">
    <button class="slider-btn prev">
      <img src="data:image/svg+xml,%3csvg width='12' height='18' viewBox='0 0 12 18' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M9.5 15.0694L3.38339 9L9.5 2.93058L8.0583 1.5L0.5 9L8.0583 16.5L9.5 15.0694Z' fill='white'/%3e %3c/svg%3e" alt="이전">
    </button>
    <div class="event-slider">
      <c:forEach var="event" items="${eventSliders}">
        <div class="slide">
          <a href="${event.linkUrl}">
            <img src="${pageContext.request.contextPath}${event.imageUrl}" alt="${event.title}">
          </a>
        </div>
      </c:forEach>
    </div>
    <button class="slider-btn next">
      <img src="data:image/svg+xml,%3csvg width='12' height='18' viewBox='0 0 12 18' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M2.5 15.0694L8.61661 9L2.5 2.93058L3.9417 1.5L11.5 9L3.9417 16.5L2.5 15.0694Z' fill='white'/%3e %3c/svg%3e" alt="다음">
    </button>
  </div>
  <!-- // 슬라이더 종료 -->

  <div style="max-width:900px; margin:40px auto;">
    <h2>실시간 랭킹</h2>
    <div style="display:flex; gap:24px; flex-wrap:wrap;">
      <c:forEach var="book" items="${rankingBooks}">
        <div style="width:160px; text-align:center;">
          <a href="${pageContext.request.contextPath}/detail?bookId=${book.id}">
            <img src="${pageContext.request.contextPath}${book.imageUrl}" alt="${book.title}" style="width:100%; border-radius:8px;">
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
            <img src="${pageContext.request.contextPath}${book.imageUrl}" alt="${book.title}" style="width:100%; border-radius:8px;">
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
              <img src="${pageContext.request.contextPath}${book.imageUrl}" alt="${book.title}" style="width:100%; border-radius:8px;">
            </a>
            <div style="margin-top:8px;">${book.title}</div>
          </div>
        </c:forEach>
      </div>
    </c:if>
  </div>

  <!-- [변경] 슬라이더 동작 script – 자동 슬라이드, 좌우 이동 -->
  <script>
    (function() {
      const slides = document.querySelectorAll('.event-slider .slide');
      const slider = document.querySelector('.event-slider');
      const prevBtn = document.querySelector('.slider-btn.prev');
      const nextBtn = document.querySelector('.slider-btn.next');
      const slideWidth = 196; // 이미지180+간격16
      let currentIdx = 0;
      let timer = null;

      function updateSlider() {
        slider.style.transform = `translateX(-${currentIdx * slideWidth}px)`;
      }
      prevBtn.onclick = () => {
        if (currentIdx > 0) currentIdx--;
        else currentIdx = slides.length - 1;
        updateSlider();
        resetTimer();
      };
      nextBtn.onclick = () => {
        if (currentIdx < slides.length - 1) currentIdx++;
        else currentIdx = 0;
        updateSlider();
        resetTimer();
      };
      function autoSlide() {
        currentIdx = (currentIdx + 1) % slides.length;
        updateSlider();
      }
      function resetTimer() {
        if (timer) clearInterval(timer);
        timer = setInterval(autoSlide, 2000);
      }
      updateSlider();
      timer = setInterval(autoSlide, 2000);
    })();
  </script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
