package com.kakaopage.expansion.dao;

import java.util.List;

public interface ManagerWorkDao {
    void assignWork(Long managerId, Long bookId);
    void removeWork(Long managerId, Long bookId);
    void removeAllWorks(Long managerId);
    List<Long> findBookIdsByManager(Long managerId);
    List<Long> findManagerIdsByBook(Long bookId);
}
