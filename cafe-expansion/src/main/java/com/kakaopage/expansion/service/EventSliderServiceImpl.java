package com.kakaopage.expansion.service;

import com.kakaopage.expansion.domain.EventSlider;
import com.kakaopage.expansion.dao.EventSliderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventSliderServiceImpl implements EventSliderService {
    @Autowired
    private EventSliderDao eventSliderDao;

    @Override
    public List<EventSlider> findAll() {
        return eventSliderDao.findAll();
    }

    @Override
    public EventSlider findById(Long id) {
        return eventSliderDao.findById(id);
    }

    @Override
    public void save(EventSlider slider) {
        if (slider.getId() == null) {
            eventSliderDao.insert(slider);
        } else {
            eventSliderDao.update(slider);
        }
    }

    @Override
    public void delete(Long id) {
        eventSliderDao.delete(id);
    }
}
