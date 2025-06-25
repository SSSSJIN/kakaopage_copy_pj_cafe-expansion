package com.kakaopage.expansion.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kakaopage.expansion.vo.UserVO;

@Mapper
public interface UserMapper {
    void insert(UserVO user);
    UserVO findByUsername(String username);
}
