package com.kakaopage.expansion.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kakaopage.expansion.dao.EventMapper;
import com.kakaopage.expansion.vo.EventVO;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventMapper eventMapper;

    @Override
    public List<EventVO> getActiveEvents() {
        return eventMapper.selectActiveEvents();
    }

    @Override
    public EventVO getEventById(Long id) {
        return eventMapper.selectEventById(id);
    }
}
