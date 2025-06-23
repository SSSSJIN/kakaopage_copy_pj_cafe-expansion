package com.kakaopage.expansion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.kakaopage.expansion.service.CommentService;
import com.kakaopage.expansion.vo.CommentVO;

@Controller
@RequestMapping("/boards/{boardId}/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /** 댓글 등록 */
    @PostMapping
    public String add(@PathVariable Long boardId, CommentVO comment) {
        comment.setBoardId(boardId);
        commentService.add(comment);
        return "redirect:/boards/" + boardId;
    }
}
