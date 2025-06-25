package com.kakaopage.expansion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kakaopage.expansion.dao.UserMapper;
import com.kakaopage.expansion.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper mapper;

    @Autowired
    public UserServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void register(UserVO user) {
        // 기본 ROLE 설정
        user.setRole("USER");
        // 비밀번호는 평문 그대로 저장(간단 구현)
        mapper.insert(user);
    }

    @Override
    public UserVO login(String username, String rawPassword) {
        UserVO dbUser = mapper.findByUsername(username);
        if (dbUser != null && dbUser.getPassword().equals(rawPassword)) {
            return dbUser;
        }
        return null;
    }
}
