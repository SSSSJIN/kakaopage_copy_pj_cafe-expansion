package com.kakaopage.expansion.service;

import com.kakaopage.expansion.vo.BookVO;
import com.kakaopage.expansion.vo.EpisodeVO;
import java.util.List;

public interface BookService {
    List<BookVO> getHotBooks();
    List<BookVO> getRankingBooks();
    List<BookVO> getRecentBooks(Long userId);
    List<BookVO> getAllBooks();
    BookVO getBookById(int id);
    List<EpisodeVO> getEpisodesByBookId(int bookId);
    List<BookVO> getBooksByTitle(String title);
    int insertBook(BookVO book);
    int updateThumbnail(Long id, String thumbnail);
    int countBookLikes(int bookId); 
}
