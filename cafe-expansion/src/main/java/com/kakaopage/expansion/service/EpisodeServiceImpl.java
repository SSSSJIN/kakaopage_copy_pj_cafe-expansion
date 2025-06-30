package com.kakaopage.expansion.service;

import com.kakaopage.expansion.dao.EpisodeMapper;
import com.kakaopage.expansion.vo.EpisodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EpisodeServiceImpl implements EpisodeService {

    @Autowired
    private EpisodeMapper episodeMapper;

    @Override
    public List<EpisodeVO> getEpisodesByBookId(Long bookId) {
        return episodeMapper.selectByBookId(bookId);
    }

    @Override
    public EpisodeVO getEpisodeById(Long id) {
        return episodeMapper.selectById(id);
    }

    @Override
    public void addEpisode(EpisodeVO episode) {
        episodeMapper.insert(episode);
    }
}
