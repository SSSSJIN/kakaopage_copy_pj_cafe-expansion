package com.kakaopage.expansion.mapper;

import com.kakaopage.expansion.domain.EventSlider;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface EventSliderMapper {
    List<EventSlider> findAll();
    EventSlider findById(Long id);
    void insert(EventSlider slider);
    void update(EventSlider slider);
    void delete(Long id);
}
