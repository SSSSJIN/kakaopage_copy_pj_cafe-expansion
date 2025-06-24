// src/main/java/com/kakaopage/expansion/controller/HomeController.java
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

    public HomeController(BookService bookService) {             
        this.bookService = bookService;
    }

    // [추가] 메인화면 요청 매핑: 루트("/")와 "/home" 모두 처리
    @GetMapping({"/", "/home"})
    public String home(Model model, HttpSession session) {
        // 1) 메인 콘텐츠 조회
        List<BookVO> mainContents = bookService.getMainContents(); // [추가] 메인 콘텐츠 서비스 호출
        // 2) 실시간 랭킹 조회
        List<BookVO> rankingList  = bookService.getRanking();      
        // 3) 최근 본 책 조회 (로그인 안 했으면 빈 리스트)
        Long userId = (Long) session.getAttribute("userId");       
        List<BookVO> recentBooks = (userId != null)
            ? bookService.getRecentBooks(userId)
            : List.of();

        model.addAttribute("mainContents", mainContents);           
        model.addAttribute("rankingList",  rankingList);            
        model.addAttribute("recentBooks",  recentBooks);            

        return "home";  // /WEB-INF/views/home.jsp
    }
}
