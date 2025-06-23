package com.kakaopage.expansion.vo;

import java.sql.Timestamp;

public class BookVO {
    private Long      id;
    private String    title;
    private Integer   episode;     // 새로 추가한 필드
    private String    author;
    private String    description;
    private String    image;
    private Timestamp regdate;
    private String    category;

    public BookVO() {
        // 기본 생성자
    }

    // 선택적으로 모든 필드를 인자로 받는 생성자도 추가할 수 있습니다.
    public BookVO(Long id, String title, Integer episode, String author,
                  String description, String image, Timestamp regdate,
                  String category) {
        this.id          = id;
        this.title       = title;
        this.episode     = episode;
        this.author      = author;
        this.description = description;
        this.image       = image;
        this.regdate     = regdate;
        this.category    = category;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisode() {
        return episode;
    }
    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getRegdate() {
        return regdate;
    }
    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
