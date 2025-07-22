package com.kakaopage.expansion.dao;

import com.kakaopage.expansion.domain.EventSlider;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EventSliderDaoImpl implements EventSliderDao {
    @Autowired
    private SqlSession sqlSession;

    private final String namespace = "com.kakaopage.expansion.mapper.EventSliderMapper";

    @Override
    public List<EventSlider> findAll() {
        return sqlSession.selectList(namespace + ".findAll");
    }

    @Override
    public EventSlider findById(Long id) {
        return sqlSession.selectOne(namespace + ".findById", id);
    }

    @Override
    public void insert(EventSlider slider) {
        sqlSession.insert(namespace + ".insert", slider);
    }

    @Override
    public void update(EventSlider slider) {
        sqlSession.update(namespace + ".update", slider);
    }

    @Override
    public void delete(Long id) {
        sqlSession.delete(namespace + ".delete", id);
    }
}
