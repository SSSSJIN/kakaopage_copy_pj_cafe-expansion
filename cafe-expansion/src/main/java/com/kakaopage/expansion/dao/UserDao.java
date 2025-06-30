package com.kakaopage.expansion.dao;

import com.kakaopage.expansion.vo.UserVO;

public interface UserDAO {
  void insertUser(UserVO user);
  UserVO selectByEmail(String email);
  void withdrawal(UserVO user) throws Exception;
}
