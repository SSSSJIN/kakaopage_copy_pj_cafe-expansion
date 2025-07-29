package com.kakaopage.expansion.vo;

// [수정] 기본 VO 클래스, 그동안 변경 없음
public class BookVO {
    private int id;
    private String title;
    private String author;
    private String genre;
    private String description;
    private String image;
    private String thumbnail;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImage() {        return image;    }
    public void setImage(String image) {        this.image = image;    }

    public String getThumbnail() { return thumbnail; }
    public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }
}
