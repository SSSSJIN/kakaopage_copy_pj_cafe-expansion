package com.kakaopage.expansion.dao;

import java.util.List;
import com.kakaopage.expansion.vo.CommentVO;

public interface CommentDao {
    /** 특정 게시글의 댓글 목록 조회 */
    List<CommentVO> selectByBoardId(Long boardId);

    /** 댓글 삽입 */
    void insert(CommentVO comment);
}
