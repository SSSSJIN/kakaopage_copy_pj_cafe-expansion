package com.kakaopage.expansion.controller;

import java.util.List;

import com.kakaopage.expansion.service.BookService;
import com.kakaopage.expansion.vo.BookVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookApiController {

    private final BookService bookService;

    public BookApiController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/hot")
    public List<BookVO> hotBooks() {
        return bookService.getHotBooks();
    }

    @GetMapping("/ranking")
    public List<BookVO> rankingBooks() {
        return bookService.getRankingBooks();
    }
}
