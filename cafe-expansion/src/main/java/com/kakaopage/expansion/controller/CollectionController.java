package com.kakaopage.expansion.controller;

import com.kakaopage.expansion.service.HistoryService;
import com.kakaopage.expansion.service.LikeService;
import com.kakaopage.expansion.vo.BookVO;
import com.kakaopage.expansion.vo.UserVO;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CollectionController {

    private final HistoryService historyService;
    private final LikeService likeService;

    @Autowired
    public CollectionController(HistoryService historyService,
                                LikeService likeService) {
        this.historyService = historyService;
        this.likeService    = likeService;
    }

    @GetMapping("/collection")
    public String collection(Model model,
                             HttpSession session,
                             @RequestParam(required = false, defaultValue = "recent") String tab) {
        // 1) 로그인 체크
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }
        // 2) userId 추출
        Long userId = ((UserVO) loginUser).getId();

        // 3) 탭에 따라 데이터 조회
        if ("liked".equals(tab)) {
            List<BookVO> likedBooks = likeService.getLikedBooksByUser(userId);
            model.addAttribute("books", likedBooks);
        } else {
            List<BookVO> recentBooks = historyService.getRecentViewsByUser(userId);
            model.addAttribute("books", recentBooks);
        }

        model.addAttribute("currentTab", tab);
        return "collection";  // collection.jsp
    }
}
