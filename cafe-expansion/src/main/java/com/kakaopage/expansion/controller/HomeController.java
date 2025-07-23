package com.kakaopage.expansion.controller;

import com.kakaopage.expansion.service.BookService;
import com.kakaopage.expansion.service.EventSliderService; // [변경] 이벤트슬라이더 서비스 추가
import com.kakaopage.expansion.vo.BookVO;
import com.kakaopage.expansion.vo.UserVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final BookService bookService;
    private final EventSliderService eventSliderService; // [변경] 필드 추가

    @Autowired
    public HomeController(BookService bookService, EventSliderService eventSliderService) { // [변경] 생성자 추가
        this.bookService = bookService;
        this.eventSliderService = eventSliderService;
    }

    @GetMapping({"/", "/home"})
    public String home(Model model, HttpSession session) {
        List<BookVO> hotBooks = bookService.getHotBooks();
        List<BookVO> rankingBooks = bookService.getRankingBooks();
        model.addAttribute("hotBooks", hotBooks);
        model.addAttribute("rankingBooks", rankingBooks);

        // [변경] 이벤트 슬라이더 데이터 추가
        model.addAttribute("eventSliders", eventSliderService.findAll());

        UserVO user = (UserVO) session.getAttribute("user");
        if (user != null) {
             List<BookVO> recentBooks = bookService.getRecentBooks(user.getId());
             model.addAttribute("recentBooks", recentBooks);
        } else {
             model.addAttribute("recentBooks", new ArrayList<>());
        }
        return "home";
    }

    @GetMapping("/mybooks")
    public String mybooks() {
        return "mybooks";
    }

    @GetMapping("/recent")
    public String recent() {
        return "recent";
    }
}
