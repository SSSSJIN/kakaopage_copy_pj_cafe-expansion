package com.kakaopage.expansion.service;

public interface BookLikeService {
    int countBookLikes(Long bookId);
    void like(Long bookId, Long userId);
    void unlike(Long bookId, Long userId);
}