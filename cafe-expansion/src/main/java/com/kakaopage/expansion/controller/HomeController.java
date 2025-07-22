package com.kakaopage.expansion.controller;

import com.kakaopage.expansion.service.BookService;
import com.kakaopage.expansion.service.EventSliderService; // [변경] 이벤트 슬라이더 서비스 추가
import com.kakaopage.expansion.domain.EventSlider;          // [변경] 이벤트 슬라이더 도메인 추가
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
    private final EventSliderService eventSliderService; // [변경] 이벤트 슬라이더 서비스 필드 추가

    @Autowired
    public HomeController(BookService bookService, EventSliderService eventSliderService) { // [변경] 생성자에 추가
        this.bookService = bookService;
        this.eventSliderService = eventSliderService;
    }

    @GetMapping({"/", "/home"})
    public String home(Model model, HttpSession session) {
        // 지금 핫한, 실시간 랭킹
        List<BookVO> hotBooks = bookService.getHotBooks();
        List<BookVO> rankingBooks = bookService.getRankingBooks();
        model.addAttribute("hotBooks", hotBooks);
        model.addAttribute("rankingBooks", rankingBooks);

        // [변경] 이벤트 슬라이더용 데이터 추가
        List<EventSlider> eventSliders = eventSliderService.findAll(); 
        model.addAttribute("eventSliders", eventSliders);

        // 로그인한 유저만 최근 본 목록 조회
        UserVO user = (UserVO) session.getAttribute("user");
        if (user != null) {
            List<BookVO> recentBooks = bookService.getRecentBooks(user.getId());
            model.addAttribute("recentBooks", recentBooks);
        } else {
            model.addAttribute("recentBooks", new ArrayList<BookVO>());
        }

        return "home";
    }

    /**
     * 보관함 페이지 이동
     */
    @GetMapping("/mybooks")
    public String mybooks() {
        return "mybooks";
    }

    /**
     * 최근 본 목록 페이지 이동
     */
    @GetMapping("/recent")
    public String recent() {
        return "recent";
    }

    // [기타 상세 페이지 이동 등 주석 처리된 기존 코드 생략]
}
