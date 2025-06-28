package com.kakaopage.expansion.dao;

// MyBatis 매퍼임을 명시
import org.apache.ibatis.annotations.Mapper;
import com.kakaopage.expansion.vo.UserVO;

/**
 * UserMapper 인터페이스
 * MyBatis에서 SQL 매퍼와 연결되는 DAO 역할
 * 반드시 @Mapper 어노테이션이 필요하며,
 * 메서드명과 UserMapper.xml의 id가 일치해야 함
 */
@Mapper  // 이 어노테이션이 있어야 MyBatis 매퍼 스캐너가 이 인터페이스를 빈으로 등록함
public interface UserMapper {

    /**
     * 회원 정보 저장 (회원가입)
     * UserMapper.xml의 <insert id="insert">와 연결됨
     * @param user 가입할 회원 정보
     */
    void insert(UserVO user);

    /**
     * username(아이디)로 회원 정보 조회 (로그인)
     * UserMapper.xml의 <select id="findByUsername">와 연결됨
     * @param username 사용자 아이디
     * @return 해당 아이디의 회원 정보(UserVO), 없으면 null
     */
    UserVO findByUsername(String username);

    // 필요하다면 추가 메서드 선언 가능
}
