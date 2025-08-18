package com.kakaopage.expansion.service;

import com.kakaopage.expansion.dao.EpisodeMapper;
import com.kakaopage.expansion.vo.EpisodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<String> splitContentByLength(String content, int length) {
        List<String> pages = new ArrayList<>();
        if (content == null) {
            return pages;
        }
        int totalLength = content.length();
        for (int i = 0; i < totalLength; i += length) {
            pages.add(content.substring(i, Math.min(totalLength, i + length)));
        }
        return pages;
    }
}
