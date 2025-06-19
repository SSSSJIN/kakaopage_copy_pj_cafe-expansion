package com.kakaopage.expansion.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kakaopage.expansion.vo.CommentVO;

@Primary
@Repository
public class CommentDaoImpl implements CommentDao {
    private final JdbcTemplate jdbc;

    public CommentDaoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<CommentVO> selectByBoardId(Long boardId) {
        String sql = "SELECT * FROM COMMENT WHERE BOARD_ID = ? ORDER BY REGDATE ASC";
        return jdbc.query(sql,
            new BeanPropertyRowMapper<>(CommentVO.class),
            boardId
        );
    }

    @Override
    public void insert(CommentVO comment) {
        String sql = "INSERT INTO COMMENT(board_id, content, writer) VALUES(?,?,?)";
        jdbc.update(sql,
            comment.getBoardId(),
            comment.getContent(),
            comment.getWriter()
        );
    }
}
