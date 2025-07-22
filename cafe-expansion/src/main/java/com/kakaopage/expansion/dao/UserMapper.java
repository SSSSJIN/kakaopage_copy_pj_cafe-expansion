package com.kakaopage.expansion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kakaopage.expansion.domain.User;
import com.kakaopage.expansion.vo.UserVO;

@Mapper
public interface UserMapper {
	List<User> findManagers();
	List<User> findAll();
	void promoteToManager(Long userId);
	void demoteManager(Long userId);
	
	UserVO findByKakaoId(String kakaoId);
    void insert(UserVO user);
    void withdrawal(UserVO user); // ← 여기!
    // 필요하다면 deleteUserImg, deleteUserPosts 등도 선언
}
