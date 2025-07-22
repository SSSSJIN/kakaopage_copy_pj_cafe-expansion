package com.kakaopage.expansion.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ManagerWorkDaoImpl implements ManagerWorkDao {
    @Autowired
    private ManagerWorkMapper mapper;

    @Override
    public void assignWork(Long managerId, Long bookId) {
        mapper.assignWork(managerId, bookId);
    }

    @Override
    public void removeWork(Long managerId, Long bookId) {
        mapper.removeWork(managerId, bookId);
    }

    @Override
    public void removeAllWorks(Long managerId) {
        mapper.removeAllWorks(managerId);
    }

    @Override
    public List<Long> findBookIdsByManager(Long managerId) {
        return mapper.findBookIdsByManager(managerId);
    }

    @Override
    public List<Long> findManagerIdsByBook(Long bookId) {
        return mapper.findManagerIdsByBook(bookId);
    }
}
