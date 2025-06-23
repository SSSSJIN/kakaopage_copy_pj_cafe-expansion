// src/main/java/com/kakaopage/expansion/controller/BookController.java
package com.kakaopage.expansion.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kakaopage.expansion.service.BookService;
import com.kakaopage.expansion.vo.BookVO;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /** 1) 지금 핫한 목록 (별도 페이지) */
    @GetMapping("/hot")
    public String hot(Model model) {
        model.addAttribute("hotBooks", bookService.getMainContents());
        return "hot";   // /WEB-INF/views/hot.jsp
    }

    /** 2) 실시간 랭킹 목록 */
    @GetMapping("/ranking")
    public String ranking(Model model) {
        model.addAttribute("rankingBooks", bookService.getRanking());
        return "ranking";  // /WEB-INF/views/ranking.jsp
    }

    /** 3) 전체 책 목록 */
    @GetMapping("/book")
    public String bookList(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "book";  // /WEB-INF/views/book.jsp
    }
}
