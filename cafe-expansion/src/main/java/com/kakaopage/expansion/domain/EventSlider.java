package com.kakaopage.expansion.domain;

import java.util.Date;

public class EventSlider {
    private Long id;
    private String type;
    private String title;
    private String imageUrl;
    private String linkUrl;
    private String description;
    private Long bookId;
    private Date startDate;
    private Date endDate;
    private Date createdAt;
    private Date updatedAt;

    // Getter
    public Long getId() { return id; }

    public String getType() { return type; }
    public String getTitle() { return title; }
    public String getImageUrl() { return imageUrl; }
    public String getLinkUrl() { return linkUrl; }
    public String getDescription() { return description; }
    public Long getBookId() { return bookId; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public Date getCreatedAt() { return createdAt; }
    public Date getUpdatedAt() { return updatedAt; }

    // Setter
    public void setId(Long id) { this.id = id; }

    public void setType(String type) { this.type = type; }
    public void setTitle(String title) { this.title = title; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setLinkUrl(String linkUrl) { this.linkUrl = linkUrl; }
    public void setDescription(String description) { this.description = description; }
    public void setBookId(Long bookId) { this.bookId = bookId; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
}
