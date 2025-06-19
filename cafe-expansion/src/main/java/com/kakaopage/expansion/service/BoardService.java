package com.kakaopage.expansion.service;

import java.util.List;
import com.kakaopage.expansion.vo.BoardVO;

public interface BoardService {
    /** 전체 게시글 조회 */
    List<BoardVO> getAll();

    /** 단일 게시글 조회 */
    BoardVO get(Long id);

    /** 새 게시글 작성 */
    void write(BoardVO board);

    /** 게시글 수정 */
    void edit(BoardVO board);

    /** 게시글 삭제 */
    void remove(Long id);
}
