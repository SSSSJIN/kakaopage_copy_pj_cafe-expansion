package com.kakaopage.expansion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public UserVO findByKakaoId(String kakaoId) {
        return mapper.findByKakaoId(kakaoId);
    }

    @Override
    public void save(UserVO user) {
        mapper.insert(user);
    }

    /**
     * 회원 탈퇴(서비스 탈퇴)
     * - 관련 데이터(이미지, 게시글, 팔로우 등)도 함께 삭제/비활성화할 수 있음
     * - 실제 DB 삭제 또는 status 변경(soft delete) 방식 모두 가능
     */
    @Override
    @Transactional
    public void withdrawal(UserVO user) throws Exception {
        // 아래 메서드들은 필요에 따라 mapper에 직접 추가/구현하세요.
        // 예시: 탈퇴시 관련 데이터도 함께 삭제
        // mapper.deleteUserImg(user.getUserNo());
        // mapper.deleteUserPosts(user.getUserNo());
        // mapper.deleteUserFollows(user.getUserNo());

        // 회원 DB에서 삭제 또는 status를 'WITHDRAWN' 등으로 변경
        mapper.withdrawal(user);
    }
}
