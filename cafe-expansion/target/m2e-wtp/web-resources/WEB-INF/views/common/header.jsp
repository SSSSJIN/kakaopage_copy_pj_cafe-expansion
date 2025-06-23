<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 상단 메인 헤더 -->
<div class="main-header" style="min-width:1200px; border-bottom:1px solid #222;">
  <!-- 로고 -->
  <div>
  <a href="/" class="logo" aria-label="카카오페이지 홈으로 이동" style="margin-right:36px;">
    <img src="https://page.kakao.com/29.6/public/images/img_logo_bi_text_l_dark.svg"
         alt="카카오페이지 로고" width="96" height="24" />
  </a><a href="/book">책</a>
  <!-- 네비게이션: '책'만 -->
  </div>
  
      <a href="/login" style="color:#fff; font-size:1.13em; text-decoration:none; font-weight:bold; display:flex; align-items:center;">
      <span>내 정보</span>
        <svg width="18" height="18" fill="#888" viewBox="0 0 24 24">
          <circle cx="11" cy="11" r="7" stroke="#888" stroke-width="2" fill="none"/>
          <line x1="17" y1="17" x2="22" y2="22" stroke="#888" stroke-width="2"/>
        </svg>
    </a>
    

  <!-- 검색창 & 내정보(로그인) -->
  <div class="search-user">
    <form action="/search" method="get" class="search-form" style="margin-right:18px;">
      <input type="text" name="q" class="search-input" placeholder="작품, 작가를 검색하세요" />
      <button type="submit" class="search-btn" aria-label="검색">
        <svg width="18" height="18" fill="#888" viewBox="0 0 24 24">
          <circle cx="11" cy="11" r="7" stroke="#888" stroke-width="2" fill="none"/>
          <line x1="17" y1="17" x2="22" y2="22" stroke="#888" stroke-width="2"/>
        </svg>
      </button>
    </form>

  </div>
</div>
<!-- 하위 탭 네비게이션 -->
<div style="background:#191919; border-bottom:1px solid #222;">
  <div style="max-width:1200px; margin:0 auto; padding:0 30px; display:flex; gap:22px; height:48px; align-items:center;">
    <a href="/hot" class="tab" style="color:#fff; font-weight:500; font-size:1.07em; text-decoration:none;">지금 핫한</a>
    <a href="/ranking" class="tab" style="color:#fff; font-weight:500; font-size:1.07em; text-decoration:none;">실시간 랭킹</a>
    <a href="/book" class="tab" style="color:#fff; font-weight:500; font-size:1.07em; text-decoration:none;">책</a>
  </div>
</div>
