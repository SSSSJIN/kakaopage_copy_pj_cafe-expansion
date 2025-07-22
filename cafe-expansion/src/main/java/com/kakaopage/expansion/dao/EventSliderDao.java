package com.kakaopage.expansion.dao;

import com.kakaopage.expansion.domain.EventSlider;
import java.util.List;

public interface EventSliderDao {
    List<EventSlider> findAll();
    EventSlider findById(Long id);
    void insert(EventSlider slider);
    void update(EventSlider slider);
    void delete(Long id);
}
