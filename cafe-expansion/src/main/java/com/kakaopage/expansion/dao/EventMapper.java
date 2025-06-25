package com.kakaopage.expansion.dao;

import java.util.List;
import com.kakaopage.expansion.vo.EventVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventMapper {
    /** 1) 현재 활성화된 이벤트들 조회 */
    List<EventVO> selectActiveEvents();

    /** 2) 단일 이벤트 조회 */
    EventVO selectEventById(Long id);
}
