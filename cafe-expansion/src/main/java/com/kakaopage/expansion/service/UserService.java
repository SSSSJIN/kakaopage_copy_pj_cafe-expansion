package com.kakaopage.expansion.service;

import com.kakaopage.expansion.vo.UserVO;

public interface UserService {

    // 기존 회원가입 메서드
    void register(UserVO user);

    // 기존 로그인 메서드
    UserVO login(String username, String rawPassword);

    // [추가] 아이디로 회원 조회 (AuthController에서 사용)
    UserVO findByUsername(String username);

    // [추가] 회원 저장 (AuthController에서 사용)
    void save(UserVO user);
}
