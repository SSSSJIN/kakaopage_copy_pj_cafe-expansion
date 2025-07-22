package com.kakaopage.expansion.service;

import java.util.List;
import com.kakaopage.expansion.vo.CommentVO;

public interface CommentService {
    List<CommentVO> getCommentsFromCommentReplyByBookId(Long bookId);
    List<CommentVO> getCommentsFromCommentsByBookId(Long bookId);
    void add(CommentVO comment);
    List<CommentVO> getByBoard(Long boardId);
}
