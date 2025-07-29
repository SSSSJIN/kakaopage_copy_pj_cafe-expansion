package com.kakaopage.expansion.controller;

import com.kakaopage.expansion.vo.BookVO;
import com.kakaopage.expansion.vo.CommentVO;
import com.kakaopage.expansion.vo.EpisodeVO;
import com.kakaopage.expansion.vo.UserVO;

import jakarta.servlet.http.HttpSession;

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
        Long nextEpisodeId = null;
        if (episodes != null && episodes.size() > 1) {
            nextEpisodeId = episodes.get(1).getId();
        } else if (episodes != null && !episodes.isEmpty()) {
            nextEpisodeId = episodes.get(0).getId();
        }
        List<CommentVO> comments = commentService.getCommentsFromCommentsByBookId((long)bookId);
        int likeCount = bookLikeService.countBookLikes((long)bookId);

        model.addAttribute("book", book);
        model.addAttribute("episodes", episodes);
        model.addAttribute("nextEpisodeId", nextEpisodeId);
        model.addAttribute("comments", comments);  // 댓글 리스트 하나만 넘김
        model.addAttribute("likeCount", likeCount);

        return "detail";
    }

    @PostMapping("/comment")
    public String postComment(@RequestParam("bookId") Long bookId, @RequestParam("content") String content) {
        CommentVO comment = new CommentVO();
        comment.setBookId(bookId);
        comment.setContent(content);
        comment.setWriter("익명");
        comment.setRegDate(LocalDateTime.now());
        commentService.add(comment); // insertcomment = add
        return "redirect:/detail?bookId=" + bookId;
    }

    @PostMapping("/like")
    public String like(@RequestParam("bookId") Long bookId) {
        Long userId = 1L; // 예제: 실제 구현 시 로그인 유저 ID로 대체
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

        // 동기화(상세설명 참조)
        if (book.getImage() == null && book.getImage() != null) {
            book.setImage(book.getImage());
        } else if (book.getImage() == null && book.getImage() != null) {
            book.setImage(book.getImage());
        }

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

    @GetMapping("/library")
    public String library(HttpSession session, Model model) {
        UserVO user = (UserVO) session.getAttribute("user");
        if (user == null) {
            // 로그인 안 된 경우 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }

        // 유저가 본 책 목록 조회 (bookService에 맞게 recentBooks 또는 기타 메소드)
        List<BookVO> bookList = bookService.getRecentBooks(user.getId());

        // 이미지 데이터 적합성 동기화
        for (BookVO book : bookList) {
            if (book.getImage() == null && book.getImage() != null) {
                book.setImage(book.getImage());
            } else if (book.getImage() == null && book.getImage() != null) {
                book.setImage(book.getImage());
            }
        }

        model.addAttribute("bookList", bookList);
        model.addAttribute("headerTitle", "보관함");
        model.addAttribute("guideText", "내가 그동안 본 책 목록입니다.");
        return "recentBooks";
    }
}
