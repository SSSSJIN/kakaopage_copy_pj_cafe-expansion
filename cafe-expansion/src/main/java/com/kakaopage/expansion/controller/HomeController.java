package com.kakaopage.expansion.controller;

import java.util.List;

import com.kakaopage.expansion.service.BookService;
import com.kakaopage.expansion.service.EventService;
import com.kakaopage.expansion.vo.BookVO;
import com.kakaopage.expansion.vo.EventVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

    @Autowired
    private EventService eventService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        // 1) 지금 핫한
        List<BookVO> hotBooks = bookService.getHotBooks();
        model.addAttribute("hotBooks", hotBooks);

        // 2) 실시간 랭킹
        List<BookVO> rankingBooks = bookService.getRankingBooks();
        model.addAttribute("rankingBooks", rankingBooks);

        // 3) 대표 이벤트
        List<EventVO> events = eventService.getActiveEvents();
        model.addAttribute("events", events);

        return "home";
    }
}
