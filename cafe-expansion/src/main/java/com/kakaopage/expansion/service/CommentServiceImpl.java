package com.kakaopage.expansion.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kakaopage.expansion.dao.CommentDao;
import com.kakaopage.expansion.vo.CommentVO;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;

    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public List<CommentVO> getByBoard(Long boardId) {
        return commentDao.selectByBoardId(boardId);
    }

    @Override
    @Transactional
    public void add(CommentVO comment) {
        commentDao.insert(comment);
    }
}
