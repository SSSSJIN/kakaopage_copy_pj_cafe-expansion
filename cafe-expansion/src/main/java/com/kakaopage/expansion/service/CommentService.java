package com.kakaopage.expansion.service;

import java.util.List;
import com.kakaopage.expansion.vo.CommentVO;

public interface CommentService {
    /** 특정 게시글의 댓글 목록 조회 */
    List<CommentVO> getByBoard(Long boardId);

    /** 댓글 추가 */
    void add(CommentVO comment);
}
