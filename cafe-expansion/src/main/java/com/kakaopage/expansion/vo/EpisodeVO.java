package com.kakaopage.expansion.vo;

import java.time.LocalDateTime;

public class EpisodeVO {
    private Long id;
    private Long bookId;
    private String title;
    private int episodeNo;
    private LocalDateTime regDate;

    // Getter/Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getEpisodeNo() { return episodeNo; }
    public void setEpisodeNo(int episodeNo) { this.episodeNo = episodeNo; }
    public LocalDateTime getRegDate() { return regDate; }
    public void setRegDate(LocalDateTime regDate) { this.regDate = regDate; }
}
