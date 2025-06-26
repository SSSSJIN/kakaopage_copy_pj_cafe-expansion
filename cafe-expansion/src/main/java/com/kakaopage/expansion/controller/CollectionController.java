package com.kakaopage.expansion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kakaopage.expansion.service.HistoryService;
import com.kakaopage.expansion.service.LikeService;
import com.kakaopage.expansion.vo.BookVO;

// ↓ javax.servlet.http.HttpSession 대신 jakarta.servlet.http.HttpSession 사용
import jakarta.servlet.http.HttpSession;

@Controller
public class CollectionController {

    private final HistoryService historyService;
    private final LikeService likeService;

    @Autowired
    public CollectionController(HistoryService historyService, LikeService likeService) {
        this.historyService = historyService;
        this.likeService    = likeService;
    }

    @GetMapping({"/collection","/collection/{tab}"})
    public String collection(
            Model model,
            HttpSession session,
            // 탭 구분용 파라미터: "recent" 또는 "liked"
            @org.springframework.web.bind.annotation.PathVariable(name="tab", required=false) String tab
    ) {
        // 로그인 체크
        Object userObj = session.getAttribute("loginUser");
        if (userObj == null) {
            // 비로그인 시 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }
        Long userId = ((com.kakaopage.expansion.vo.UserVO)userObj).getId();

        // 기본 탭: recent
        if (tab == null || !"liked".equals(tab)) {
            List<BookVO> recent = historyService.getRecentViewsByUser(userId);
            model.addAttribute("books", recent);
            model.addAttribute("activeTab", "recent");
        } else {
            List<BookVO> liked = likeService.getLikedBooksByUser(userId);
            model.addAttribute("books", liked);
            model.addAttribute("activeTab", "liked");
        }
        return "collection";   // WEB-INF/views/collection.jsp
    }
}
