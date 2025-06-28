package com.kakaopage.expansion.controller;

import com.kakaopage.expansion.service.UserService;
import com.kakaopage.expansion.vo.UserVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 인증(로그인/회원가입) 관련 컨트롤러
 */
@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // 로그인 폼 페이지
    @GetMapping("/login")
    public String loginForm() {
        return "login"; // /WEB-INF/views/login.jsp
    }

    // 회원가입 폼 페이지
    @GetMapping("/signup")
    public String signupForm() {
        return "signup"; // /WEB-INF/views/signup.jsp
    }

    // === [1] 일반 폼 전송(HTML form) 방식 지원 추가 ===

    /**
     * 로그인 폼 전송 처리 (일반 폼 전송)
     * @param username 아이디
     * @param password 비밀번호
     */
    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            Model model) {
        UserVO user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // 로그인 성공: 세션에 사용자 정보 저장
            session.setAttribute("user", user);
            return "redirect:/home";
        } else {
            // 로그인 실패: 에러 메시지 전달
            model.addAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "login";
        }
    }

    /**
     * 회원가입 폼 전송 처리 (일반 폼 전송)
     * @param username 아이디
     * @param password 비밀번호
     */
    @PostMapping("/signup")
    public String signup(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {
        // 이미 존재하는 아이디인지 확인
        if (userService.findByUsername(username) != null) {
            model.addAttribute("error", "이미 존재하는 아이디입니다.");
            return "signup";
        }
        // 회원가입 처리
        UserVO user = new UserVO();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole("USER");
        userService.save(user);
        // 회원가입 성공 후 로그인 페이지로 이동
        return "redirect:/login";
    }

    // === [2] 기존 JSON 방식(AJAX)도 유지하고 싶으면 아래 코드도 함께 사용 ===

    /**
     * 로그인 (AJAX/JSON 방식)
     */
    @PostMapping("/api/auth/login")
    @ResponseBody
    public String loginApi(@RequestBody UserVO user, HttpSession session) {
        UserVO dbUser = userService.findByUsername(user.getUsername());
        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("user", dbUser);
            return "{\"result\":\"success\"}";
        } else {
            return "{\"result\":\"fail\"}";
        }
    }

    /**
     * 회원가입 (AJAX/JSON 방식)
     */
    @PostMapping("/api/auth/signup")
    @ResponseBody
    public String signupApi(@RequestBody UserVO user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            return "{\"result\":\"duplicate\"}";
        }
        user.setRole("USER");
        userService.save(user);
        return "{\"result\":\"success\"}";
    }
}
