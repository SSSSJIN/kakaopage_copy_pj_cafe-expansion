package com.kakaopage.expansion.service;

import com.kakaopage.expansion.dao.CommentDao;
import com.kakaopage.expansion.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public List<CommentVO> getCommentsByBoard(Long boardId) {
        return commentDao.selectByBoardId(boardId);
    }

    @Override
    public void addComment(CommentVO vo) {
        commentDao.insert(vo);
    }

    @Override
    public void removeComment(Long commentId) {
        commentDao.delete(commentId);
    }
}
