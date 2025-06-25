package com.kakaopage.expansion.controller;

import com.kakaopage.expansion.service.UserService;
import com.kakaopage.expansion.vo.UserVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService us) {
        this.userService = us;
    }

    // ── (1) 회원가입 폼
    @GetMapping("/signup")
    public String signupForm() {
        return "signup";  // signup.jsp
    }

    // ── (2) 가입 처리
    @PostMapping("/signup")
    public String doSignup(UserVO form) {
        userService.register(form);
        return "redirect:/login";
    }

    // ── (3) 로그인 폼
    @GetMapping("/login")
    public String loginForm() {
        return "login";   // login.jsp
    }

    // ── (4) 로그인 처리
    @PostMapping("/login")
    public String doLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session
    ) {
        UserVO user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("loginUser", user);
            return "redirect:/home";
        }
        return "redirect:/login?error";
    }

    // ── (5) 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }
}
