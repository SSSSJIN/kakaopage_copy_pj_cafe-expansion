package com.kakaopage.expansion.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.kakaopage.expansion.vo.BookVO;

@Mapper
public interface BookMapper {

    List<BookVO> getHotBooks();
    List<BookVO> getRankingBooks();
    List<BookVO> getRecentBooks(@Param("userId") Long userId);
    List<BookVO> getAllBooks();
    BookVO      getBookById(@Param("id") Long id);
    List<BookVO> getBooksByTitle(@Param("title") String title);
    int          insertBook(BookVO book);

    /** 새로 추가: id에 해당하는 행의 thumbnail 컬럼을 업데이트 */
    int updateThumbnail(@Param("id") Long id,
                        @Param("thumbnail") String thumbnail);
}
