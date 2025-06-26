package com.kakaopage.expansion.controller;

import com.kakaopage.expansion.service.UserService;
import com.kakaopage.expansion.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

/**
 * 인증 컨트롤러: 로그인/로그아웃/회원가입
 */
@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    /** 로그인 페이지 */
    @GetMapping("/login")
    public String loginPage() {
        return "login";  // /WEB-INF/views/login.jsp
    }

    /** 로그인 처리 (AJAX JSON) */
    @PostMapping("/api/auth/login")
    @ResponseBody
    public Map<String, Object> doLogin(
            @RequestBody LoginRequest req,
            HttpSession session
    ) {
        Map<String, Object> resp = new HashMap<>();
        UserVO user = userService.authenticate(req.getId(), req.getPw());
        if (user != null) {
            session.setAttribute("loginUser", user);
            resp.put("success", true);
        } else {
            resp.put("success", false);
            resp.put("message", "아이디 또는 비밀번호가 올바르지 않습니다.");
        }
        return resp;
    }

    /** 로그아웃 처리 */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    /** 회원가입 페이지 */
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";  // /WEB-INF/views/signup.jsp
    }

    /** 회원가입 처리 */
    @PostMapping("/api/auth/signup")
    @ResponseBody
    public Map<String, Object> doSignup(
            @RequestBody SignupRequest req
    ) {
        Map<String, Object> resp = new HashMap<>();
        boolean ok = userService.register(req.getUsername(), req.getPassword());
        resp.put("success", ok);
        if (!ok) {
            resp.put("message", "회원가입에 실패했습니다.");
        }
        return resp;
    }

    /** 로그인/회원가입 JSON 요청 파라미터 바인딩용 DTO */
    public static class LoginRequest {
        private String id;
        private String pw;
        // getter / setter
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getPw() { return pw; }
        public void setPw(String pw) { this.pw = pw; }
    }

    public static class SignupRequest {
        private String username;
        private String password;
        // getter / setter
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
