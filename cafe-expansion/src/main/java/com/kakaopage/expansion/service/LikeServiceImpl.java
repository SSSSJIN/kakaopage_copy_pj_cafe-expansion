package com.kakaopage.expansion.service;

import com.kakaopage.expansion.dao.LikedBookMapper;
import com.kakaopage.expansion.vo.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikedBookMapper mapper;

    @Autowired
    public LikeServiceImpl(LikedBookMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<BookVO> getLikedBooksByUser(Long userId) {
        return mapper.selectLikedBooksByUser(userId);
    }
}
