package com.kakaopage.expansion.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ManagerWorkMapper {
    void assignWork(@Param("managerId") Long managerId, @Param("bookId") Long bookId);
    void removeWork(@Param("managerId") Long managerId, @Param("bookId") Long bookId);
    void removeAllWorks(@Param("managerId") Long managerId);
    List<Long> findBookIdsByManager(@Param("managerId") Long managerId);
    List<Long> findManagerIdsByBook(@Param("bookId") Long bookId);
}
