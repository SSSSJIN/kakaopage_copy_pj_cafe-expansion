package com.kakaopage.expansion.service;

import java.util.List;
import com.kakaopage.expansion.vo.BookVO;
import com.kakaopage.expansion.vo.EpisodeVO;

public interface BookService {
    BookVO getBookById(int id);
    List<BookVO> getHotBooks();
    List<BookVO> getRankingBooks();
    List<BookVO> getBooksByTitle(String title);
    List<EpisodeVO> getEpisodesByBookId(int bookId);
    int countBookLikes(int bookId);
    List<BookVO> getRecentBooks(Long userId);
    List<BookVO> getAllBooks();
    int updateThumbnail(Long id, String thumbnail);
}
