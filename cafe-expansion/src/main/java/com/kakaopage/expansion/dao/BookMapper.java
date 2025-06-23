package com.kakaopage.expansion.dao;

import java.util.List;
import com.kakaopage.expansion.vo.BookVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    /** 1) 메인(지금 핫한) 10권 조회 */
    List<BookVO> getMainContents();

    /** 2) 실시간 랭킹 10권 조회 */
    List<BookVO> getRanking();

    /** 3) 사용자별 최근 본 책 10권 조회 */
    List<BookVO> getRecentBooks(Long userId);

    /** 4) 모든 책 조회 */
    List<BookVO> selectAll();

    /** 5) ID로 단일 책 조회 */
    BookVO selectById(Long id);

    /** 6) 제목으로 책 검색 */
    List<BookVO> selectByTitle(String title);

    /** 7) 새 책 등록 */
    int insert(BookVO book);
}
