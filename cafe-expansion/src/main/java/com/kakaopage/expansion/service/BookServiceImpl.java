package com.kakaopage.expansion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakaopage.expansion.dao.BookMapper;
import com.kakaopage.expansion.vo.BookVO;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper mapper;

    @Override
    public List<BookVO> getHotBooks() {
        return mapper.getHotBooks();
    }

    @Override
    public List<BookVO> getRankingBooks() {
        return mapper.getRankingBooks();
    }

    @Override
    public List<BookVO> getRecentBooks(Long userId) {
        return mapper.getRecentBooks(userId);
    }

    @Override
    public List<BookVO> getAllBooks() {
        return mapper.getAllBooks();
    }

    @Override
    public BookVO getBookById(Long id) {
        return mapper.getBookById(id);
    }

    @Override
    public List<BookVO> getBooksByTitle(String title) {
        return mapper.getBooksByTitle(title);
    }

    @Override
    public void insertBook(BookVO book) {
        mapper.insertBook(book);
    }

    @Override
    public void updateThumbnail(Long id, String thumbnail) {
        mapper.updateThumbnail(id, thumbnail);
    }
}
