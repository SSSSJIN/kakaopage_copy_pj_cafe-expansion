package com.kakaopage.expansion.dao;

import com.kakaopage.expansion.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    private final CommentMapper commentMapper;

    @Autowired
    public CommentDaoImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentVO> selectByBoardId(Long boardId) {
        return commentMapper.selectByBoardId(boardId);
    }

    @Override
    public void insert(CommentVO vo) {
        commentMapper.insert(vo);
    }

    @Override
    public void delete(Long commentId) {
        commentMapper.delete(commentId);
    }
}
