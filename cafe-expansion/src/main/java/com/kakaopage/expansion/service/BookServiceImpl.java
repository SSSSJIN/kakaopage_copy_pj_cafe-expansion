package com.kakaopage.expansion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kakaopage.expansion.dao.BookMapper;
import com.kakaopage.expansion.vo.BookVO;

@Service
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;

    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    /** 1) 지금 핫한 */
    @Override
    public List<BookVO> getMainContents() {
        // selectMainContents() → getMainContents()
        return bookMapper.getMainContents();
    }

    /** 2) 실시간 랭킹 */
    @Override
    public List<BookVO> getRanking() {
        // selectRanking() → getRanking()
        return bookMapper.getRanking();
    }

    /** 3) 최근 본 책 */
    @Override
    public List<BookVO> getRecentBooks(Long userId) {
        // selectRecentBooks(...) → getRecentBooks(...)
        return bookMapper.getRecentBooks(userId);
    }

    /** 4) 모든 책 조회 */
    @Override
    public List<BookVO> getAll() {
        return bookMapper.selectAll();
    }

    /** 5) ID로 단일 책 조회 */
    @Override
    public BookVO get(Long id) {
        return bookMapper.selectById(id);
    }

    /** 6) 제목으로 책 검색 */
    @Override
    public List<BookVO> getByTitle(String title) {
        return bookMapper.selectByTitle(title);
    }

    /** 7) 새 책 등록 */
    @Override
    public void add(BookVO book) {
        bookMapper.insert(book);
    }
}
