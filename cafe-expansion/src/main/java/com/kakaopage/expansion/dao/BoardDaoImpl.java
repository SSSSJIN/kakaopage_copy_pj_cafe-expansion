package com.kakaopage.expansion.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kakaopage.expansion.vo.BoardVO;

@Primary
@Repository
public class BoardDaoImpl implements BoardDao {
    private final JdbcTemplate jdbc;

    public BoardDaoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<BoardVO> selectAll() {
        String sql = "SELECT * FROM BOARD ORDER BY REGDATE DESC";
        return jdbc.query(sql,
            new BeanPropertyRowMapper<>(BoardVO.class)
        );
    }

    @Override
    public BoardVO selectById(Long id) {
        String sql = "SELECT * FROM BOARD WHERE ID = ?";
        return jdbc.queryForObject(sql,
            new BeanPropertyRowMapper<>(BoardVO.class),
            id
        );
    }

    @Override
    public void insert(BoardVO board) {
        String sql = "INSERT INTO BOARD(title, content, writer) VALUES(?,?,?)";
        jdbc.update(sql,
            board.getTitle(),
            board.getContent(),
            board.getWriter()
        );
    }

    @Override
    public void update(BoardVO board) {
        String sql = "UPDATE BOARD SET title = ?, content = ? WHERE ID = ?";
        jdbc.update(sql,
            board.getTitle(),
            board.getContent(),
            board.getId()
        );
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM BOARD WHERE ID = ?";
        jdbc.update(sql, id);
    }
}
