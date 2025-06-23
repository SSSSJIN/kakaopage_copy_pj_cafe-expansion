package com.kakaopage.expansion.service;

import java.util.List;
import com.kakaopage.expansion.vo.BookVO;

public interface BookService {
    List<BookVO> getMainContents();           // 지금 핫한
    List<BookVO> getRanking();                // 실시간 랭킹
    List<BookVO> getRecentBooks(Long userId); // 최근 본 책

    // (필요에 따라 기존 CRUD 메서드도 추가)


    /**
     * 모든 책 조회
     * @return DB의 BOOK 테이블 전체 리스트
     */
    List<BookVO> getAll();

    /**
     * 단일 책 조회
     * @param id 책의 고유 ID
     * @return 해당 ID의 BookVO
     */
    BookVO get(Long id);

    /**
     * 제목으로 책 검색
     * @param title 검색할 제목
     * @return 제목이 일치하는 책 리스트
     */
    List<BookVO> getByTitle(String title);

    /**
     * 새 책 등록
     * @param book 추가할 BookVO
     */
    void add(BookVO book);
}
