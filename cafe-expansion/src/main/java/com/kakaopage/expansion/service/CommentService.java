package com.kakaopage.expansion.service;
import java.util.List;
import com.kakaopage.expansion.vo.CommentVO;

public interface CommentService {
    List<CommentVO> getCommentsByBookId(Long bookId);
    void insertComment(CommentVO comment);
}