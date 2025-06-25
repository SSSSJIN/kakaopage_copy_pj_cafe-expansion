package com.kakaopage.expansion.dao;

import com.kakaopage.expansion.vo.BookVO;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ViewHistoryMapper {
    List<BookVO> selectRecentViewsByUser(Long userId);
}
