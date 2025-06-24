package com.kakaopage.expansion.service;

import com.kakaopage.expansion.vo.MemberVO;

public interface MemberService {
    /** 로그인 체크 */
    MemberVO findById(String id);

    /** 회원가입 */
    int insertMember(MemberVO member);
}
