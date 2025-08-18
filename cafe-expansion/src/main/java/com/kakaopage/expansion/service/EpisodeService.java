package com.kakaopage.expansion.service;

import com.kakaopage.expansion.vo.EpisodeVO;

import java.util.List;

public interface EpisodeService {

    List<EpisodeVO> getEpisodesByBookId(Long bookId);

    EpisodeVO getEpisodeById(Long id);

    void addEpisode(EpisodeVO episode);

    /**
     * 에피소드 내용을 일정 글자 수 단위로 분할
     * @param content 전체 내용
     * @param length 페이지당 글자 수
     * @return 분할된 페이지 리스트
     */
    List<String> splitContentByLength(String content, int length);
}
