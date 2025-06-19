package com.kakaopage.expansion.controller;

import org.springframework.stereotype.Controller;
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

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping({ "/", "/home" })
	public String home() {
		return "home";
	}

	@GetMapping("/signup")
	public String signupForm() {
		return "signup";
	}

	@PostMapping("/signup")
	public String signupSubmit(UserVO user) {
		userService.register(user);
		return "redirect:/login";
	}
}
