package com.kakaopage.expansion.controller;

import java.util.List;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.kakaopage.expansion.service.BookService;
import com.kakaopage.expansion.vo.BookVO;

@Controller
public class HomeController {

    private final BookService bookService;

    // 생성자 주입
    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 메인 화면 매핑
     * "/" 또는 "/home" 으로 요청이 들어오면 home.jsp 로 포워딩
     */
    @GetMapping({"/", "/home"})
    public String home(Model model, HttpSession session) {
        // 1) 메인 컨텐츠 조회
        List<BookVO> mainContents = bookService.getMainContents();
        // 2) 실시간 랭킹 조회
        List<BookVO> rankingList = bookService.getRanking();
        // 3) 최근 본 책 조회 (로그인 안 했으면 빈 리스트)
        Long userId = (Long) session.getAttribute("userId");
        List<BookVO> recentBooks = (userId != null)
            ? bookService.getRecentBooks(userId)
            : List.of();

        // 뷰에 모델 데이터 등록
        model.addAttribute("mainContents", mainContents);
        model.addAttribute("rankingList",  rankingList);
        model.addAttribute("recentBooks",  recentBooks);

        // /WEB-INF/views/home.jsp
        return "home";
    }
}
