package com.kakaopage.expansion.dao;

import com.kakaopage.expansion.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insert(UserVO user);
    UserVO findByUsername(String username);
}
