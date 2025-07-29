package com.kakaopage.expansion.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakaopage.expansion.vo.CommentVO;
import com.kakaopage.expansion.dao.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentVO> getCommentsFromCommentReplyByBookId(Long bookId) {
        return commentMapper.getCommentsFromCommentReplyByBookId(bookId);
    }

    @Override
    public List<CommentVO> getCommentsFromCommentsByBookId(Long bookId) {
        return commentMapper.getCommentsFromCommentsByBookId(bookId);
    }

    @Override
    public void add(CommentVO comment) {
        commentMapper.add(comment);
    }

    @Override
    public List<CommentVO> getByBoard(Long boardId) {
        return commentMapper.getByBoard(boardId);
    }
}
