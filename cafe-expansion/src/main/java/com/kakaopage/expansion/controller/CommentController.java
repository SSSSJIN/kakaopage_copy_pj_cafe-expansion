package com.kakaopage.expansion.controller;

import com.kakaopage.expansion.vo.CommentVO;
import com.kakaopage.expansion.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/boards/{bookId}/comments")
public class CommentController {

    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public String add(@PathVariable Long bookId, CommentVO comment) {
        comment.setBookId(bookId); // boardId → bookId로 변경
        commentService.add(comment); // add 메서드명 일치
        return "redirect:/boards/" + bookId + "/comments";
    }
}
