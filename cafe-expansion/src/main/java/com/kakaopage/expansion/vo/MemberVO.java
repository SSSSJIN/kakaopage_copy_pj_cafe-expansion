package com.kakaopage.expansion.vo;

/**
 * MemberVO: 회원 정보를 담는 Value Object
 */
public class MemberVO {
    private String id;
    private String password;

    // ——————————————————————————————
    // Getter / Setter
    // ——————————————————————————————
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
