package com.kakaopage.expansion.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kakaopage.expansion.vo.UserVO;

@Primary
@Repository
public class UserDaoImpl implements UserDao {
	private final JdbcTemplate jdbc;

	public UserDaoImpl(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public void insert(UserVO user) {
		String sql = "INSERT INTO USERS(username, password, role) VALUES(?,?,?)";
		jdbc.update(sql,
			user.getUsername(),
			user.getPassword(),
			user.getRole()
		);
	}

	@Override
	public UserVO findByUsername(String username) {
		String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
		return jdbc.queryForObject(sql,
			new BeanPropertyRowMapper<>(UserVO.class),
			username
		);
	}
}
