package com.kakaopage.expansion.vo;

import java.time.LocalDateTime;
import java.util.Date;

public class EpisodeVO {

    private Long id;
    private Long bookId;
    private String title;
    private int episodeNo;
    private LocalDateTime regDate;

    // content 필드는 viewer.jsp 등에서 ${ep.content} 접근시 500에러 방지용
    private String content;
    private Date regDateAsDate;

    public Date getRegDateAsDate() {
        return regDateAsDate;
    }

    public void setRegDateAsDate(Date regDateAsDate) {
        this.regDateAsDate = regDateAsDate;
    }

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

    // detail.jsp에서 ${ep.date}로 접근할 수 있도록
    public LocalDateTime getDate() { return regDate; }

    // viewer.jsp 등에서 ${ep.content} 접근시 500에러 방지
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
