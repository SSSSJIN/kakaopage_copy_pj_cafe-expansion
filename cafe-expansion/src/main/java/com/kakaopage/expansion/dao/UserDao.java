package com.kakaopage.expansion.dao;

import com.kakaopage.expansion.vo.UserVO;

public interface UserDao {
	void insert(UserVO user);
	UserVO findByUsername(String username);
}
