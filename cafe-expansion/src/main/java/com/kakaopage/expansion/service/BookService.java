package com.kakaopage.expansion.service;

import java.util.List;
import com.kakaopage.expansion.vo.BookVO;

public interface BookService {
    /** 메인화면 “지금 핫한” */
    List<BookVO> getHotBooks();

    /** 메인화면 “실시간 랭킹” */
    List<BookVO> getRankingBooks();

    /** 최근 본 책 */
    List<BookVO> getRecentBooks(Long userId);

    /** 전체 책 조회 */
    List<BookVO> getAllBooks();

    /** 단일 책 */
    BookVO getBookById(Long id);

    /** 제목으로 검색 */
    List<BookVO> getBooksByTitle(String title);

    /** 새 책 등록 */
    void insertBook(BookVO book);

    /** 썸네일 URL 업데이트 */
    void updateThumbnail(Long id, String thumbnail);
}
