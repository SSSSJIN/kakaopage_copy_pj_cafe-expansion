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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MVC: 이벤트 상세 페이지 (이벤트 정보 + 추천 책)
 */
@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private BookService bookService;

    /**
     * GET /event/{id}
     * - 이벤트 정보
     * - 추천 책 (실시간 랭킹 상위 5권)
     */
    @GetMapping("/{id}")
    public String eventPage(@PathVariable("id") Long id, Model model) {
        // 1) 이벤트 정보
        EventVO evt = eventService.getEventById(id);
        model.addAttribute("event", evt);

        // 2) 추천 책: 실시간 랭킹 상위 5권
        List<BookVO> recBooks = bookService.getRankingBooks();  
        if (recBooks.size() > 5) {
            recBooks = recBooks.subList(0, 5);
        }
        model.addAttribute("recBooks", recBooks);

        return "event";  // /WEB-INF/views/event.jsp
    }
}
