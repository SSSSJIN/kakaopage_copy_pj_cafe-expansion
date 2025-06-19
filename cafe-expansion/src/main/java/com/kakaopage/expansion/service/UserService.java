package com.kakaopage.expansion.service;

import com.kakaopage.expansion.vo.UserVO;

public interface UserService {
	void register(UserVO user);
	UserVO getByUsername(String username);
}
