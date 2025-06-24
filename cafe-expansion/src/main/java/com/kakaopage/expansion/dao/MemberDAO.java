package com.kakaopage.expansion.dao;

import com.kakaopage.expansion.vo.MemberVO;

public interface MemberDAO {
    /** 아이디로 회원 조회 */
    MemberVO findById(String id);

    /** 회원가입(insertMember): 새로운 회원을 DB에 저장 */
    int insertMember(MemberVO member);
}
