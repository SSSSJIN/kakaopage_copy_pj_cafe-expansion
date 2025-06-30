package com.kakaopage.expansion.controller;

import com.kakaopage.expansion.vo.BookVO;
import com.kakaopage.expansion.vo.CommentVO;
import com.kakaopage.expansion.vo.EpisodeVO;
import com.kakaopage.expansion.service.BookService;
import com.kakaopage.expansion.service.CommentService;
import com.kakaopage.expansion.service.BookLikeService;
import com.kakaopage.expansion.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class BookController {

    @Autowired private BookService bookService;
    @Autowired private CommentService commentService;
    @Autowired private BookLikeService bookLikeService;
    @Autowired private EpisodeService episodeService;

    // 상세 페이지
    @GetMapping("/detail")
    public String detail(@RequestParam("bookId") int bookId, Model model) {
        BookVO book = bookService.getBookById(bookId);
        List<EpisodeVO> episodes = episodeService.getEpisodesByBookId((long)bookId);
        List<CommentVO> comments = commentService.getCommentsByBookId((long)bookId);
        int likeCount = bookLikeService.countBookLikes((long)bookId);
        Long nextEpisodeId = (episodes != null && episodes.size() > 1) ? episodes.get(1).getId() : (episodes != null && !episodes.isEmpty() ? episodes.get(0).getId() : null);

        model.addAttribute("book", book);
        model.addAttribute("episodes", episodes);
        model.addAttribute("comments", comments);
        model.addAttribute("likeCount", likeCount);
        model.addAttribute("nextEpisodeId", nextEpisodeId);

        return "detail";
    }

    @PostMapping("/comment")
    public String postComment(@RequestParam("bookId") Long bookId, @RequestParam("content") String content) {
        CommentVO comment = new CommentVO();
        comment.setBookId(bookId);
        comment.setContent(content);
        comment.setWriter("익명");
        comment.setRegDate(LocalDateTime.now());
        commentService.insertComment(comment);
        return "redirect:/detail?bookId=" + bookId;
    }

    @PostMapping("/like")
    public String like(@RequestParam("bookId") Long bookId) {
        Long userId = 1L;
        bookLikeService.like(bookId, userId);
        return "redirect:/detail?bookId=" + bookId;
    }

    @PostMapping("/unlike")
    public String unlike(@RequestParam("bookId") Long bookId) {
        Long userId = 1L;
        bookLikeService.unlike(bookId, userId);
        return "redirect:/detail?bookId=" + bookId;
    }

    @GetMapping("/viewer")
    public String viewer(@RequestParam("bookId") int bookId,
                         @RequestParam("episodeId") Long episodeId,
                         Model model) {
        BookVO book = bookService.getBookById(bookId);
        EpisodeVO episode = episodeService.getEpisodeById(episodeId);
        List<EpisodeVO> episodes = bookService.getEpisodesByBookId(bookId);
        Long nextEpisodeId = null;
        for (int i = 0; i < episodes.size(); i++) {
            if (episodes.get(i).getId().equals(episodeId) && i < episodes.size() - 1) {
                nextEpisodeId = episodes.get(i + 1).getId();
                break;
            }
        }
        model.addAttribute("book", book);
        model.addAttribute("episode", episode);
        model.addAttribute("nextEpisodeId", nextEpisodeId);
        return "viewer";
    }
}
