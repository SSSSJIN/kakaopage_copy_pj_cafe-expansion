package com.kakaopage.expansion.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kakaopage.expansion.dao.UserDao;
import com.kakaopage.expansion.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	private final UserDao               userDao;
	private final BCryptPasswordEncoder encoder;

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
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
		userDao.insert(user);
	}

	@Override
	public UserVO getByUsername(String username) {
		return userDao.findByUsername(username);
	}
}
