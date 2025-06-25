package com.kakaopage.expansion.controller;

import com.kakaopage.expansion.service.BookService;
import com.kakaopage.expansion.vo.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final BookService bookService;

    @Autowired
    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 메인화면: "/" 또는 "/home" 으로 접근 가능하도록 매핑
     */
    @GetMapping({"/", "/home"})
    public String home(Model model) {
        // “지금 핫한”과 “실시간 랭킹” 리스트
        List<BookVO> hot     = bookService.getHotBooks();
        List<BookVO> ranking = bookService.getRankingBooks();

        model.addAttribute("hotBooks",     hot);
        model.addAttribute("rankingBooks", ranking);
        return "home";  // /WEB-INF/views/home.jsp
    }
}
