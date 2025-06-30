package com.kakaopage.expansion.service;

import com.kakaopage.expansion.vo.EpisodeVO;
import java.util.List;

public interface EpisodeService {
    List<EpisodeVO> getEpisodesByBookId(Long bookId);
    EpisodeVO getEpisodeById(Long id);
    void addEpisode(EpisodeVO episode);
}
