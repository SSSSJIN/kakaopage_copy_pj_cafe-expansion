package com.kakaopage.expansion.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kakaopage.expansion.vo.UserVO;

@Mapper
public interface UserMapper {
    UserVO findByKakaoId(String kakaoId);
    void insert(UserVO user);
    void withdrawal(UserVO user); // ← 여기!
    // 필요하다면 deleteUserImg, deleteUserPosts 등도 선언
}
