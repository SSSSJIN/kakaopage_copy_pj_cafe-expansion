package com.kakaopage.expansion.controller;

import com.kakaopage.expansion.service.UserService;
import com.kakaopage.expansion.vo.UserVO;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // 카카오 REST API Key (appkey)
    private static final String KAKAO_CLIENT_ID = "e8da3210f814e01f61a25d163730ebd2";
    // 카카오 Redirect URI (카카오 개발자센터 등록 필요)
    private static final String KAKAO_REDIRECT_URI = "http://localhost:8080/cafe-expansion/kakao-callback";

    /** 로그인/회원가입 통합 폼 (카카오 버튼만 노출) */
    @GetMapping({"/login", "/signup"})
    public String loginForm() {
        return "login"; // signup.jsp도 login.jsp와 동일하게 처리
    }

    /**
     * 카카오 로그인 콜백
     * code 파라미터로 토큰 발급 → 사용자 정보 조회 → 회원 등록/조회 → 세션 저장 → 홈으로 이동
     */
    @GetMapping("/kakao-callback")
    public String kakaoCallback(@RequestParam("code") String code, HttpSession session, Model model) {
        try {
            // 1. 인가코드로 토큰 요청
            RestTemplate restTemplate = new RestTemplate();
            String tokenUrl = "https://kauth.kakao.com/oauth/token";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            String body = "grant_type=authorization_code"
                    + "&client_id=" + KAKAO_CLIENT_ID
                    + "&redirect_uri=" + KAKAO_REDIRECT_URI
                    + "&code=" + code;

            HttpEntity<String> request = new HttpEntity<>(body, headers);
            ResponseEntity<String> response = restTemplate.exchange(tokenUrl, HttpMethod.POST, request, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode tokenJson = objectMapper.readTree(response.getBody());
            String accessToken = tokenJson.get("access_token").asText();

            // 2. 토큰으로 사용자 정보 요청
            String userInfoUrl = "https://kapi.kakao.com/v2/user/me";
            HttpHeaders userHeaders = new HttpHeaders();
            userHeaders.add("Authorization", "Bearer " + accessToken);
            HttpEntity<String> userRequest = new HttpEntity<>(userHeaders);
            ResponseEntity<String> userResponse = restTemplate.exchange(userInfoUrl, HttpMethod.GET, userRequest, String.class);

            JsonNode userJson = objectMapper.readTree(userResponse.getBody());
            String kakaoId = userJson.get("id").asText();
            String email = userJson.path("kakao_account").path("email").asText("");
            String nickname = userJson.path("properties").path("nickname").asText("");
            String profileImageUrl = userJson.path("properties").path("profile_image").asText("");

            // 3. 회원 여부 확인/등록
            UserVO user = userService.findByKakaoId(kakaoId);

            if (user == null) {
                user = new UserVO();
                user.setKakaoId(kakaoId);

                // USERNAME은 반드시 NOT NULL이어야 하므로, 아래처럼 보장
                String username;
                if (email != null && !email.isEmpty()) {
                    username = email;
                } else if (nickname != null && !nickname.isEmpty()) {
                    username = nickname;
                } else {
                    username = "kakao_" + kakaoId;
                }
                user.setUsername(username);

                user.setNickname(nickname);
                user.setEmail(email);
                user.setProfileImageUrl(profileImageUrl);
                user.setRole("USER");
                user.setPassword("KAKAO_USER"); // 소셜 로그인 계정 구분용 임의값

                userService.save(user);
            }

            // 4. 세션 저장
            session.setAttribute("user", user);
            session.setAttribute("access_token", accessToken);

            // 5. 홈으로 리다이렉트
            return "redirect:/home";
        } catch (Exception e) {
            model.addAttribute("error", "카카오 로그인 실패: " + e.getMessage());
            return "kakao-callback";
        }
    }

    /** 카카오 로그아웃 (세션 무효화 + 카카오 API 토큰 만료) */
    @GetMapping("/logout")
    public String logout(HttpSession session, @RequestParam(value = "redirectHome", required = false) String redirectHome) {
        String accessToken = (String) session.getAttribute("access_token");
        if (accessToken != null) {
            try {
                String logoutUrl = "https://kapi.kakao.com/v1/user/logout";
                HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization", "Bearer " + accessToken);
                HttpEntity<String> request = new HttpEntity<>(headers);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.exchange(logoutUrl, HttpMethod.POST, request, String.class);
            } catch (Exception e) {
                // 무시
            }
        }
        session.invalidate();
        if ("true".equals(redirectHome)) {
            return "redirect:/home";
        } else {
            return "redirect:/login";
        }
    }


    @GetMapping("/account")
    public String accountPage(HttpSession session, Model model) {
        UserVO user = (UserVO) session.getAttribute("user");
        if (user == null) return "redirect:/login";
        model.addAttribute("user", user);
        return "account";
    }

    @PostMapping("/withdraw")
    public String withdrawUser(HttpSession session) {
        UserVO user = (UserVO) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login"; // 로그인 안 된 경우
        }
        try {
            userService.withdrawal(user); // 실제 탈퇴 처리
            session.invalidate(); // 세션 무효화
            return "redirect:/login"; // 탈퇴 후 로그인 페이지로 이동
        } catch (Exception e) {
            // 에러 처리: 에러 페이지나 메시지 전달 등
            return "errorPage";
        }
    }
}
