package com.kakaopage.expansion.dao;

import com.kakaopage.expansion.vo.EpisodeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface EpisodeMapper {
    List<EpisodeVO> selectByBookId(@Param("bookId") Long bookId);
    EpisodeVO selectById(@Param("id") Long id);
    void insert(EpisodeVO vo);
}
