package com.kakaopage.expansion.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kakaopage.expansion.dao.BoardDao;
import com.kakaopage.expansion.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardDao boardDao;

    public BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    public List<BoardVO> getAll() {
        return boardDao.selectAll();
    }

    @Override
    public BoardVO get(Long id) {
        return boardDao.selectById(id);
    }

    @Override
    @Transactional
    public void write(BoardVO board) {
        boardDao.insert(board);
    }

    @Override
    @Transactional
    public void edit(BoardVO board) {
        boardDao.update(board);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        boardDao.delete(id);
    }
}
