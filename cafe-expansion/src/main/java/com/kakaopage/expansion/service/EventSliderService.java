package com.kakaopage.expansion.service;

import com.kakaopage.expansion.domain.EventSlider;
import java.util.List;

public interface EventSliderService {
    List<EventSlider> findAll();
    EventSlider findById(Long id);
    void save(EventSlider slider);
    void delete(Long id);
}
