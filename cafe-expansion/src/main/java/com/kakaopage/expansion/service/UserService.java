package com.kakaopage.expansion.service;

import com.kakaopage.expansion.vo.UserVO;

public interface UserService {
    UserVO findByKakaoId(String kakaoId);
    void save(UserVO user);
    void withdrawal(UserVO user) throws Exception; // ← 추가
}
