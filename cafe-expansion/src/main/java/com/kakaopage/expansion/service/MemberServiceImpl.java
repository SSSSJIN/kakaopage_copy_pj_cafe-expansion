package com.kakaopage.expansion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kakaopage.expansion.dao.MemberDAO;
import com.kakaopage.expansion.service.MemberService;
import com.kakaopage.expansion.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;

    /** 로그인 시 아이디 조회 → DAO의 findById 호출 */
    @Override
    public MemberVO findById(String id) {
        return memberDAO.findById(id);
    }

    /** 회원가입 처리 → DAO의 insertMember 호출 */
    @Override
    public int insertMember(MemberVO member) {
        return memberDAO.insertMember(member);
    }
}
