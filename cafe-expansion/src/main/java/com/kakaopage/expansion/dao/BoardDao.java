package com.kakaopage.expansion.dao;

import java.util.List;
import com.kakaopage.expansion.vo.BoardVO;

public interface BoardDao {

    /** 전체 게시글 조회 */
    List<BoardVO> selectAll();

    /** 단일 게시글 조회 */
    BoardVO selectById(Long id);

    /** 새 게시글 삽입 */
    void insert(BoardVO board);

    /** 게시글 수정 */
    void update(BoardVO board);

    /** 게시글 삭제 */
    void delete(Long id);
}
