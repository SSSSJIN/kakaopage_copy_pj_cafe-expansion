package com.kakaopage.expansion.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.kakaopage.expansion.vo.BookVO;
import com.kakaopage.expansion.vo.EpisodeVO;

@Mapper
public interface BookMapper {
    List<BookVO> getHotBooks();
    List<BookVO> getRankingBooks();
    List<BookVO> getRecentBooks(@Param("userId") Long userId);
    List<BookVO> getAllBooks();
    BookVO getBookById(@Param("id") int id); // int로 통일
    List<BookVO> getBooksByTitle(@Param("title") String title);

    // 에피소드 연동
    List<EpisodeVO> getEpisodesByBookId(@Param("bookId") int bookId);
    int countBookLikes(@Param("bookId") int bookId);
}
