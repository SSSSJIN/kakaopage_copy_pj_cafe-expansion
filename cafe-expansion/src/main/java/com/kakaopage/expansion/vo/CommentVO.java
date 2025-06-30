package com.kakaopage.expansion.vo;

import java.time.LocalDateTime;

public class CommentVO {
    private Long id;
    private Long bookId; // boardId → bookId로 변경
    private String content;
    private String writer;
    private LocalDateTime regDate;

    // Getter/Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }
    public LocalDateTime getRegDate() { return regDate; }
    public void setRegDate(LocalDateTime regDate) { this.regDate = regDate; }
}
