// src/main/java/com.kakaopage.expansion.controller.HomeController.java
package com.kakaopage.expansion.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import com.kakaopage.expansion.service.BookService;
import com.kakaopage.expansion.vo.BookVO;

@Controller
public class HomeController {

	private final BookService bookService;

	public HomeController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping({"/", "/home"})
	public String home(Model model, HttpSession session) {
		// 1) “지금 핫한” 리스트
		List<BookVO> mainContents = bookService.getMainContents();
		// 2) “실시간 랭킹” 리스트
		List<BookVO> rankingList  = bookService.getRanking();
		// 3) 최근 본 책 (로그인 안 했으면 빈 리스트)
		Long userId = (Long) session.getAttribute("userId");
		List<BookVO> recentBooks = (userId != null)
			? bookService.getRecentBooks(userId)
			: List.of();

		model.addAttribute("mainContents", mainContents);
		model.addAttribute("rankingList",  rankingList);
		model.addAttribute("recentBooks",  recentBooks);

		return "home";  // ✅ home.jsp로 연결되도록 수정
	}
}
