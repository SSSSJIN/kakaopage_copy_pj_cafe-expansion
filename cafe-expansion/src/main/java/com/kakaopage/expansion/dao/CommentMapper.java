package com.kakaopage.expansion.dao;

import com.kakaopage.expansion.vo.CommentVO;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * MyBatis 매퍼 인터페이스: CommentMapper.xml 에 정의된 SQL을 호출합니다.
 */
@Mapper
public interface CommentMapper {

    /**
     * 게시글 ID로 댓글 목록 조회
     * @param boardId 게시글 ID
     * @return CommentVO 리스트
     */
    List<CommentVO> selectByBoardId(Long boardId);

    /**
     * 새 댓글 삽입
     * @param vo CommentVO
     */
    void insert(CommentVO vo);

    /**
     * 댓글 삭제
     * @param commentId 삭제할 댓글 ID
     */
    void delete(Long commentId);
}
