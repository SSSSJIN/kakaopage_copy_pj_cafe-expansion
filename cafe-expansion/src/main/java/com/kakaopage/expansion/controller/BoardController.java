// src/main/java/com/kakaopage/expansion/controller/BoardController.java
package com.kakaopage.expansion.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.kakaopage.expansion.service.BoardService;
import com.kakaopage.expansion.service.CommentService;
import com.kakaopage.expansion.vo.BoardVO;
import com.kakaopage.expansion.vo.CommentVO;

@Controller
@RequestMapping("/boards")
public class BoardController {

    private final BoardService   boardService;
    private final CommentService commentService;

    public BoardController(BoardService boardService,
                           CommentService commentService) {
        this.boardService   = boardService;
        this.commentService = commentService;
    }

    /** 1) 게시글 목록 */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("boards", boardService.getAll());
        return "boardList";
    }

    /** 2) 새 글 작성 폼 */
    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("board", new BoardVO());
        return "boardForm";
    }

    /** 3) 새 글 등록 처리 */
    @PostMapping
    public String create(BoardVO board) {
        boardService.write(board);
        return "redirect:/boards";
    }

    /** 4) 게시글 상세 (+댓글 목록) */
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.get(id));
        // 서비스 메서드명 변경: getByBoardId → getByBoard
        List<CommentVO> comments = commentService.getByBoard(id);
        model.addAttribute("comments", comments);
        model.addAttribute("newComment", new CommentVO());
        return "boardDetail";
    }

    /** 5) 수정 폼 */
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.get(id));
        return "boardForm";
    }

    /** 6) 수정 처리 */
    @PostMapping("/{id}/edit")
    public String editSubmit(@PathVariable Long id, BoardVO board) {
        board.setId(id);
        boardService.edit(board);
        return "redirect:/boards/" + id;
    }

    /** 7) 삭제 처리 */
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        boardService.remove(id);
        return "redirect:/boards";
    }
}
