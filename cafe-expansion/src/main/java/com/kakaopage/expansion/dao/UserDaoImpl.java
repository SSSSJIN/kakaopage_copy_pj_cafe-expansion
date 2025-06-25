package com.kakaopage.expansion.dao;

import org.springframework.stereotype.Repository;
import com.kakaopage.expansion.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;

@Repository
public class UserDAOImpl implements UserDAO {
  private final SqlSessionTemplate sql;
  @Autowired
  public UserDAOImpl(SqlSessionTemplate sql) { this.sql = sql; }

  @Override
  public void insertUser(UserVO user) {
    sql.insert("com.kakaopage.expansion.dao.UserMapper.insertUser", user);
  }

  @Override
  public UserVO selectByEmail(String email) {
    return sql.selectOne("com.kakaopage.expansion.dao.UserMapper.selectByEmail", email);
  }
}
