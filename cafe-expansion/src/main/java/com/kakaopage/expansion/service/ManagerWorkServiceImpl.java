package com.kakaopage.expansion.service;

import com.kakaopage.expansion.dao.ManagerWorkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ManagerWorkServiceImpl implements ManagerWorkService {
    @Autowired
    private ManagerWorkDao managerWorkDao;

    @Override
    public void assignWork(Long managerId, Long bookId) {
        managerWorkDao.assignWork(managerId, bookId);
    }

    @Override
    public void removeWork(Long managerId, Long bookId) {
        managerWorkDao.removeWork(managerId, bookId);
    }

    @Override
    public void removeAllWorks(Long managerId) {
        managerWorkDao.removeAllWorks(managerId);
    }

    @Override
    public List<Long> findBookIdsByManager(Long managerId) {
        return managerWorkDao.findBookIdsByManager(managerId);
    }

    @Override
    public List<Long> findManagerIdsByBook(Long bookId) {
        return managerWorkDao.findManagerIdsByBook(bookId);
    }
}
