package com.kakaopage.expansion.vo;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class UserVO {
    private Long id;

    @NotBlank(message="아이디를 입력하세요")
    private String username;

    @NotBlank(message="비밀번호를 입력하세요")
    private String password;

    private String role;
}
