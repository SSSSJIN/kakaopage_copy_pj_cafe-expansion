package com.kakaopage.expansion.dao;

import com.kakaopage.expansion.vo.CommentVO;
import java.util.List;

/**
* 댓글 DAO
*/
public interface CommentDao {
    List<CommentVO> getCommentsFromCommentReplyByBookId(long bookId);  // 리플용
    List<CommentVO> getCommentsFromCommentsByBookId(long bookId);      // 일반댓글용

    /**
    * 게시글 ID로 댓글 목록 조회
    */
    List<CommentVO> selectByBoardId(Long boardId);

    /**
    * 새 댓글 삽입
    */
    void insert(CommentVO vo);

    /**
    * 댓글 삭제
    */
    void delete(Long commentId);
}
