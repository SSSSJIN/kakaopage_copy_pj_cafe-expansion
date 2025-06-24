// src/main/java/com/kakaopage/expansion/controller/AuthController.java
package com.kakaopage.expansion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// [추가] 로그인 파라미터 바인딩
import org.springframework.web.bind.annotation.RequestParam;
// [추가] Flash 메시지 전달용
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
// [수정] javax.servlet → Jakarta EE 9+
import jakarta.servlet.http.HttpSession;

import com.kakaopage.expansion.service.UserService;
import com.kakaopage.expansion.vo.UserVO;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    /** 로그인 폼 (GET) */
    @GetMapping("/login")
    public String loginForm() {
        return "login";   // /WEB-INF/views/login.jsp
    }

    /** 로그인 처리 (POST) */                                                  
    @PostMapping("/login")                                                   
    public String loginSubmit(
        @RequestParam("id") String id,                                        
        @RequestParam("password") String pw,                                  
        HttpSession session,                                                  
        RedirectAttributes rttr                                            
    ) {
        // [수정] findById → getByUsername 호출하도록 변경 :contentReference[oaicite:2]{index=2}
        UserVO user = userService.getByUsername(id);                          
        if (user == null) {
            rttr.addFlashAttribute("msg", "NOT_REGISTERED");
            return "redirect:/login";
        }
        if (!user.getPassword().equals(pw)) {
            rttr.addFlashAttribute("msg", "WRONG_PW");
            return "redirect:/login";
        }
        // 로그인 성공 → 세션 저장
        session.setAttribute("loginUser", user);
        return "redirect:/home";
    }

    /** 회원가입 폼 (GET) */
    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new UserVO());
        return "signup";  // /WEB-INF/views/signup.jsp
    }

    /** 회원가입 처리 (POST) */
    @PostMapping("/signup")
    public String signupSubmit(
        UserVO user,
        RedirectAttributes rttr                                               
    ) {
        userService.register(user);
        rttr.addFlashAttribute("msg", "SIGNUP_OK");                           
        return "redirect:/login";                                             
    }
}
