package com.kakaopage.expansion.service;

import java.util.List;
import com.kakaopage.expansion.vo.EventVO;

public interface EventService {
    /** 활성화된 이벤트 리스트 */
    List<EventVO> getActiveEvents();

    /** 단일 이벤트 조회 */
    EventVO getEventById(Long id);
}
