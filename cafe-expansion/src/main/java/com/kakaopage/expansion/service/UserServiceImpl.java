package com.kakaopage.expansion.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kakaopage.expansion.dao.UserMapper;
import com.kakaopage.expansion.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;
	private final BCryptPasswordEncoder encoder;

	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
		this.encoder = new BCryptPasswordEncoder();
	}

	@Override
	@Transactional
	public void register(UserVO user) {
		// 비밀번호 암호화
		String raw = user.getPassword();
		user.setPassword(encoder.encode(raw));

		// 기본 역할 설정
		user.setRole("ROLE_USER");

		// MyBatis 매퍼 사용
		userMapper.insert(user);
	}

	@Override
	public UserVO getByUsername(String username) {
		return userMapper.findByUsername(username);
	}
}
