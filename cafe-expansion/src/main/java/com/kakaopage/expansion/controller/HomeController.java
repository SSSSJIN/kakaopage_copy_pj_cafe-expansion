package com.kakaopage.expansion.controller;

import com.kakaopage.expansion.service.BookService;
import com.kakaopage.expansion.vo.BookVO;
import com.kakaopage.expansion.vo.UserVO;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final BookService bookService;

    @Autowired
    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({"/", "/home"})
    public String home(Model model, HttpSession session) {
        // 지금 핫한, 실시간 랭킹
        List<BookVO> hotBooks = bookService.getHotBooks();
        List<BookVO> rankingBooks = bookService.getRankingBooks();
        model.addAttribute("hotBooks", hotBooks);
        model.addAttribute("rankingBooks", rankingBooks);

        // 로그인한 유저만 최근 본 목록 조회
        UserVO user = (UserVO) session.getAttribute("user");
        if (user != null) {
            List<BookVO> recentBooks = bookService.getRecentBooks(user.getId());
            model.addAttribute("recentBooks", recentBooks);
        } else {
            model.addAttribute("recentBooks", new ArrayList<BookVO>()); // 빈 리스트 또는 null
        }
        return "home";
    }



    /**
     * 보관함 페이지 이동
     */
    @GetMapping("/mybooks")
    public String mybooks() {
        return "mybooks"; // /WEB-INF/views/mybooks.jsp
    }

    /**
     * 최근 본 목록 페이지 이동
     */
    @GetMapping("/recent")
    public String recent() {
        return "recent"; // /WEB-INF/views/recent.jsp
    }

    /**
     * 상세 페이지 이동 (DB 연동)
     * bookId로 BookVO 조회해서 model에 담기
     */
//    @GetMapping("/detail")
//    public String detail(@RequestParam("bookId") Long bookId, Model model) {
//        BookVO book = bookService.getBookById(bookId);
//        model.addAttribute("book", book);
//        return "detail"; // /WEB-INF/views/detail.jsp
//    }
}
