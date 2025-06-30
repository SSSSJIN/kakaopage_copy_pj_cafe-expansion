package com.kakaopage.expansion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kakaopage.expansion.dao.BookLikeMapper;

@Service
public class BookLikeServiceImpl implements BookLikeService {
    @Autowired
    private BookLikeMapper bookLikeMapper;

    @Override
    public int countBookLikes(Long bookId) {
        return bookLikeMapper.countBookLikes(bookId);
    }

    @Override
    public void like(Long bookId, Long userId) {
        if (bookLikeMapper.existsLike(bookId, userId) == 0) {
            bookLikeMapper.insertBookLike(bookId, userId);
        }
        // 이미 좋아요한 경우 아무 동작 안함
    }

    @Override
    public void unlike(Long bookId, Long userId) {
        bookLikeMapper.deleteBookLike(bookId, userId);
    }
}
