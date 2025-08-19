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
import java.util.ArrayList;
import java.util.List;
import java.time.ZoneId;
import java.util.Date;

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
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         HttpSession session, Model model) {

        // 기본 정보 조회
        BookVO book = bookService.getBookById(bookId);
        EpisodeVO episode = episodeService.getEpisodeById(episodeId);

        // ★ 디버깅 로그 추가
        System.out.println("=== VIEWER DEBUG ===");
        System.out.println("Book ID: " + bookId);
        System.out.println("Episode ID: " + episodeId);
        System.out.println("Episode: " + (episode != null ? episode.getTitle() : "NULL"));
        System.out.println("Episode Content: " + (episode != null && episode.getContent() != null ? 
            "길이 " + episode.getContent().length() + "자" : "NULL"));
        if (episode != null && episode.getContent() != null) {
            System.out.println("Content 앞부분: " + episode.getContent().substring(0, Math.min(100, episode.getContent().length())));
        }

        // LocalDateTime → Date 변환
        if (episode.getRegDate() != null) {
            Date regDateAsDate = Date.from(episode.getRegDate().atZone(ZoneId.systemDefault()).toInstant());
            episode.setRegDateAsDate(regDateAsDate);
        }

        // 페이지 분할
        List<String> pages = new ArrayList<>();
        if (episode != null && episode.getContent() != null && !episode.getContent().trim().isEmpty()) {
            pages = episodeService.splitContentByLength(episode.getContent(), 650);
        } else {
            // ★ 내용이 없을 때 임시 더미 데이터
            pages.add("새벽녘, 주인공은 폐허가 된 성채의 복도를 천천히 걸었다. 어제의 전투는 모든 것을 바꿔놓았다. 창문 너머로 들어오는 냉랭한 달빛은 이따금 피로 물든 바닥을 희미하게 비추었다. 먼지 쌓인 붉은 융단 위로 가늘게 남겨진 발자국, 그리고 검은 연기로 그을린 천장. \"여긴 정말 끝장이구나.\" 그는 조용히 중얼거렸다.");
            pages.add("방 한쪽 구석, 깨진 갑옷 틈에서 오래된 일기장이 발견됐다. 낡은 가죽 표지에는 보풀과 피 얼룩이 잔뜩 묻어 있었다. 주인공은 일기장을 들고 팔을 들어 하늘을 가리켰다. \"언젠가 나도 이곳을 떠날 날이 오겠지.\" 손 끝에 닿는 하늘은 아직 새벽빛을 담고 있었다.");
            pages.add("계단을 내려가던 중 한 줄기 찬바람이 머리카락을 스쳐 지나갔다. \"누구지?\" 그림자가 벽을 타고 벗어났다. 낯선 기척, 문틈 사이로 빛나는 붉은 눈동자. \"너, 여기서 무엇을 찾는 거지?\" 목소리에 담긴 경계와 불안. 하지만 주인공은 멈추지 않았다.");
        }
        
        System.out.println("분할된 페이지 수: " + pages.size());
        if (!pages.isEmpty()) {
            System.out.println("첫 번째 페이지: " + pages.get(0).substring(0, Math.min(50, pages.get(0).length())));
        }

        if (page < 0) page = 0;
        if (page >= pages.size()) page = pages.size() - 1;

        // 이전화/다음화 정보
        List<EpisodeVO> allEpisodes = episodeService.getEpisodesByBookId((long)bookId);
        
        Long prevEpisodeId = null;
        Long nextEpisodeId = null;
        int prevEpisodeLastPage = 0;
        
        for (int i = 0; i < allEpisodes.size(); i++) {
            if (allEpisodes.get(i).getId().equals(episodeId)) {
                if (i > 0) {
                    prevEpisodeId = allEpisodes.get(i - 1).getId();
                    EpisodeVO prevEpisode = allEpisodes.get(i - 1);
                    List<String> prevPages = episodeService.splitContentByLength(
                        prevEpisode.getContent() != null ? prevEpisode.getContent() : "", 650);
                    prevEpisodeLastPage = Math.max(0, prevPages.size() - 1);
                }
                if (i < allEpisodes.size() - 1) {
                    nextEpisodeId = allEpisodes.get(i + 1).getId();
                }
                break;
            }
        }

        // 모델에 데이터 추가
        model.addAttribute("book", book);
        model.addAttribute("episode", episode);
        model.addAttribute("pages", pages);
        model.addAttribute("pageIndex", page);
        model.addAttribute("totalPages", pages.size());
        model.addAttribute("prevEpisodeId", prevEpisodeId);
        model.addAttribute("nextEpisodeId", nextEpisodeId);
        model.addAttribute("prevEpisodeLastPage", prevEpisodeLastPage);

        // 댓글 정보
        List<CommentVO> comments = commentService.getCommentsByEpisodeId(episodeId);
        model.addAttribute("comments", comments);

        UserVO user = (UserVO) session.getAttribute("user");
        model.addAttribute("user", user);

        System.out.println("=== DEBUG END ===");
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
