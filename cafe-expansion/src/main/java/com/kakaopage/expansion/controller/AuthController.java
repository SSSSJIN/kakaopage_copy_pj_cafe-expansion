package com.kakaopage.expansion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.kakaopage.expansion.service.UserService;
import com.kakaopage.expansion.vo.UserVO;

@Controller
public class AuthController {
	private final UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

	/** 로그인 폼 */
	@GetMapping("/login")
	public String login() {
		return "login";   // /WEB-INF/views/login.jsp
	}

	/** 회원가입 폼 */
	@GetMapping("/signup")
	public String signupForm(Model model) {
		model.addAttribute("user", new UserVO());
		return "signup";  // /WEB-INF/views/signup.jsp
	}

	/** 회원가입 처리 */
	@PostMapping("/signup")
	public String signupSubmit(UserVO user) {
		userService.register(user);
		return "redirect:/login?signupSuccess";
	}
}
