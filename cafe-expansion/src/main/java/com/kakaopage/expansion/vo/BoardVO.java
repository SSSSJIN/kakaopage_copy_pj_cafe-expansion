package com.kakaopage.expansion.vo;

import java.time.LocalDateTime;   // java.time API 사용
import lombok.Data;

@Data
public class BoardVO {
    private Long            id;
    private String          title;
    private String          content;
    private String          writer;
    private LocalDateTime   regDate;   // util.Date 대신 LocalDateTime
}
