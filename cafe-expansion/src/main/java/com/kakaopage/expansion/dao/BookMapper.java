package com.kakaopage.expansion.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.kakaopage.expansion.vo.BookVO;
import com.kakaopage.expansion.vo.EpisodeVO;

@Mapper
public interface BookMapper {
    BookVO getBookById(@Param("id") int id);
    List<BookVO> getHotBooks();
    List<BookVO> getRankingBooks();
    List<BookVO> getBooksByTitle(@Param("title") String title);
    List<EpisodeVO> getEpisodesByBookId(@Param("bookId") int bookId);
    int countBookLikes(@Param("bookId") int bookId);
    List<BookVO> getRecentBooks(@Param("userId") Long userId);
    List<BookVO> getAllBooks();
    int updateThumbnail(@Param("id") Long id, @Param("thumbnail") String thumbnail);
}
