package com.kakaopage.expansion.vo;

import java.time.LocalDate;

public class BookVO {
    private Long id;
    private String title;
    private String episode;
    private String author;
    private String description;
    private String image;
    private String thumbnail;     // ← 새로 추가
    private LocalDate regdate;
    private String category;

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

    public String getEpisode() {
        return episode;
    }
    public void setEpisode(String episode) {
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

    public String getThumbnail() {       // ← 새로 추가
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public LocalDate getRegdate() {
        return regdate;
    }
    public void setRegdate(LocalDate regdate) {
        this.regdate = regdate;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
