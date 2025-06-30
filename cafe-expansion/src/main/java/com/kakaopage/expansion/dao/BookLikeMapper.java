package com.kakaopage.expansion.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookLikeMapper {
    int countBookLikes(@Param("bookId") Long bookId);
    Integer existsLike(@Param("bookId") Long bookId, @Param("userId") Long userId);
    int insertBookLike(@Param("bookId") Long bookId, @Param("userId") Long userId);
    int deleteBookLike(@Param("bookId") Long bookId, @Param("userId") Long userId);
}
