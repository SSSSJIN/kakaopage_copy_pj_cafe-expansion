package com.kakaopage.expansion.vo;

import java.util.Date;

public class UserVO {
    private Long id;                 // ID (PK)
    private String username;         // USERNAME
    private String password;         // PASSWORD (카카오 로그인시 UUID 등 임의값)
    private String role;             // ROLE
    private String kakaoId;          // KAKAO_ID
    private String nickname;         // NICKNAME
    private String email;            // EMAIL
    private String profileImageUrl;  // PROFILE_IMAGE_URL
    private Date joinDate;           // JOIN_DATE

    // --- Getter/Setter ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getKakaoId() { return kakaoId; }
    public void setKakaoId(String kakaoId) { this.kakaoId = kakaoId; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getProfileImageUrl() { return profileImageUrl; }
    public void setProfileImageUrl(String profileImageUrl) { this.profileImageUrl = profileImageUrl; }

    public Date getJoinDate() { return joinDate; }
    public void setJoinDate(Date joinDate) { this.joinDate = joinDate; }
}
