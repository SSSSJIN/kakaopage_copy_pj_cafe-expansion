package com.kakaopage.expansion.service;

import java.util.List;

import com.kakaopage.expansion.domain.User;
import com.kakaopage.expansion.vo.UserVO;

public interface UserService {
    UserVO findByKakaoId(String kakaoId);
    void save(UserVO user);
    void withdrawal(UserVO user) throws Exception; // ← 추가
    
    List<User> findManagers();                 // 중간관리자(작가) 목록 반환
    List<User> findAll();                      // 전체 회원 반환
    void promoteToManager(Long userId);        // 중간관리자 권한 부여
    void demoteManager(Long userId);           // 중간관리자 권한 해제
}
