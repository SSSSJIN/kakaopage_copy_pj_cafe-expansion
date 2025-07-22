package com.kakaopage.expansion.service;

import java.util.List;

public interface ManagerWorkService {
    void assignWork(Long managerId, Long bookId);
    void removeWork(Long managerId, Long bookId);
    void removeAllWorks(Long managerId);
    List<Long> findBookIdsByManager(Long managerId);
    List<Long> findManagerIdsByBook(Long bookId);
}
