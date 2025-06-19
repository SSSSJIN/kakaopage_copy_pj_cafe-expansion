package com.kakaopage.expansion.vo;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CommentVO {
    private Long            id;
    private Long            boardId;
    private String          content;
    private String          writer;
    private LocalDateTime   regDate;
}
