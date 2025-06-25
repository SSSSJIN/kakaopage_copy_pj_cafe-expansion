package com.kakaopage.expansion.service;

import com.kakaopage.expansion.vo.BookVO;
import java.util.List;

public interface HistoryService {
    List<BookVO> getRecentViewsByUser(Long userId);
}
