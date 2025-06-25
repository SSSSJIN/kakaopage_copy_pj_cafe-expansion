package com.kakaopage.expansion.dao;

import com.kakaopage.expansion.vo.BoardVO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Stub 구현체: 우선 빈으로만 등록되어, BoardService가 DI 오류 없이 기동되도록 합니다.
 * 차후에 MyBatis 매퍼 기반 구현체로 교체하시면 됩니다.
 */
@Repository
public class BoardDaoImpl implements BoardDao {

    @Override
    public List<BoardVO> selectAll() {
        // TODO: 실제 매퍼 구현 이전까지는 빈 리스트 반환
        return new ArrayList<>();
    }

    @Override
    public BoardVO selectById(Long id) {
        // TODO: 실제 매퍼 구현 이전까지는 null 반환
        return null;
    }

    @Override
    public void insert(BoardVO vo) {
        // no-op
    }

    @Override
    public void update(BoardVO vo) {
        // no-op
    }

    @Override
    public void delete(Long id) {
        // no-op
    }
}
