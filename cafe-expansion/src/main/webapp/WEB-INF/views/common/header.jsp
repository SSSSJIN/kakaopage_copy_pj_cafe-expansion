<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- ✅ 상단 메인 헤더: 로고, 책, 검색, 로그인/회원가입 구성 -->
<header style="display: flex;
			   align-items: center;
			   justify-content: space-between;
			   padding: 20px 40px;
			   background-color: #ffffff;
			   border-bottom: 1px solid #ddd;
			   font-family: 'Pretendard', sans-serif;
			   font-size: 16px;">

	<!-- 왼쪽 영역: 로고 + 책 메뉴 -->
	<div style="display: flex; align-items: center; gap: 30px;">
		<!-- ✅ 로고 클릭 시 home.jsp로 이동 -->
		<a href="${pageContext.request.contextPath}/home" style="display: flex; align-items: center;">
			<img src="${pageContext.request.contextPath}/resources/image/cat.jfif"
			     alt="로고"
			     style="width: 120px; height: auto;">
		</a>

		<!-- 책 메뉴 -->
		<a href="${pageContext.request.contextPath}/book"
		   style="text-decoration: none; color: #333; font-weight: 500;">
			책
		</a>
	</div>

	<!-- 가운데 영역: 검색 입력창 -->
	<div style="flex-grow: 1; text-align: center;">
		<form action="${pageContext.request.contextPath}/search" method="get" style="display: inline-block;">
			<input type="text" name="keyword"
			       placeholder="제목, 작가명으로 검색"
			       style="width: 320px;
						  padding: 10px 15px;
						  border: 1px solid #ccc;
						  border-radius: 25px;
						  background-color: #f8f8f8;
						  font-size: 15px;">
			<button type="submit"
			        style="margin-left: 8px;
						   padding: 10px 18px;
						   background-color: #ffeb00;
						   border: none;
						   border-radius: 25px;
						   font-weight: 600;
						   cursor: pointer;">
				검색
			</button>
		</form>
	</div>

	<!-- 오른쪽 영역: 로그인 / 회원가입 -->
	<div style="display: flex; gap: 20px;">
		<a href="${pageContext.request.contextPath}/login"
		   style="text-decoration: none; color: #555; font-weight: 400;">
			로그인
		</a>
		<a href="${pageContext.request.contextPath}/signup"
		   style="text-decoration: none; color: #555; font-weight: 400;">
			회원가입
		</a>
	</div>
</header>

<!-- ✅ 하위 탭 네비게이션 (카카오페이지 스타일 통일 적용) -->
<nav style="background-color: #191919; border-bottom: 1px solid #222;">
	<div style="max-width: 1200px;
				margin: 0 auto;
				display: flex;
				align-items: center;
				justify-content: flex-start;
				gap: 30px;
				padding: 0 40px;
				height: 48px;">

		<a href="${pageContext.request.contextPath}/hot"
		   style="color: #ffffff;
				  font-weight: 500;
				  font-size: 16px;
				  text-decoration: none;
				  font-family: 'Pretendard', sans-serif;">
			지금 핫한
		</a>

		<a href="${pageContext.request.contextPath}/ranking"
		   style="color: #ffffff;
				  font-weight: 500;
				  font-size: 16px;
				  text-decoration: none;
				  font-family: 'Pretendard', sans-serif;">
			실시간 랭킹
		</a>

		<a href="${pageContext.request.contextPath}/book"
		   style="color: #ffffff;
				  font-weight: 500;
				  font-size: 16px;
				  text-decoration: none;
				  font-family: 'Pretendard', sans-serif;">
			책
		</a>
	</div>
</nav>
