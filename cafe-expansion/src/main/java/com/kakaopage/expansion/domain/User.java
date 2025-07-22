package com.kakaopage.expansion.domain;

// 도메인 모델 - 실제 경로 및 이름은 프로젝트마다 다를 수 있음
public class User {
    private Long id;
    private String username;
    private String email;
    private String role; // 예: ROLE_ADMIN,ROLE_MANAGER,ROLE_USER

    // getter/setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
