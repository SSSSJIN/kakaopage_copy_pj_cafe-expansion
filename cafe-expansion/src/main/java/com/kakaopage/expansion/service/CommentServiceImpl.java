package com.kakaopage.expansion.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kakaopage.expansion.dao.CommentMapper;
import com.kakaopage.expansion.vo.CommentVO;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentVO> getCommentsByBookId(Long bookId) {
        return commentMapper.getCommentsByBookId(bookId);
    }


    @Override
    public void add(CommentVO comment) {
        commentMapper.insert(comment);
    }
}
