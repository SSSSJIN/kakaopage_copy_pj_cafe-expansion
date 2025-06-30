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

    /** (추가) 썸네일 업데이트 - 실제로 필요 없다면 빈 구현 */
    default int updateThumbnail(Long id, String thumbnail) {
        // 게시판에서 썸네일 업데이트가 필요 없다면 0 반환
        return 0;
    }
}
