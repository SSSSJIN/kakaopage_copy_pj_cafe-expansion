package com.kakaopage.expansion.service;

import com.kakaopage.expansion.dao.ViewHistoryMapper;
import com.kakaopage.expansion.vo.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final ViewHistoryMapper mapper;

    @Autowired
    public HistoryServiceImpl(ViewHistoryMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<BookVO> getRecentViewsByUser(Long userId) {
        return mapper.selectRecentViewsByUser(userId);
    }
}
