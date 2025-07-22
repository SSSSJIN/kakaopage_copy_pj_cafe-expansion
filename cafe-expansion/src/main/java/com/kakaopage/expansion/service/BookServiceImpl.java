package com.kakaopage.expansion.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kakaopage.expansion.dao.BookMapper;
import com.kakaopage.expansion.vo.BookVO;
import com.kakaopage.expansion.vo.EpisodeVO;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public BookVO getBookById(int id) {
        return bookMapper.getBookById(id);
    }

    @Override
    public List<BookVO> getHotBooks() {
        return bookMapper.getHotBooks();
    }

    @Override
    public List<BookVO> getRankingBooks() {
        return bookMapper.getRankingBooks();
    }

    @Override
    public List<BookVO> getBooksByTitle(String title) {
        return bookMapper.getBooksByTitle(title);
    }

    @Override
    public List<EpisodeVO> getEpisodesByBookId(int bookId) {
        return bookMapper.getEpisodesByBookId(bookId);
    }

    @Override
    public int countBookLikes(int bookId) {
        return bookMapper.countBookLikes(bookId);
    }

    @Override
    public List<BookVO> getRecentBooks(Long userId) {
        return bookMapper.getRecentBooks(userId);
    }

    @Override
    public List<BookVO> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    @Override
    public int updateThumbnail(Long id, String thumbnail) {
        return bookMapper.updateThumbnail(id, thumbnail);
    }
}
