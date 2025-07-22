package com.kakaopage.expansion.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.kakaopage.expansion.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        String[] roles = user.getRole().split(",");
        boolean isAdmin = Arrays.asList(roles).contains("ROLE_ADMIN");
        if (!isAdmin) {
            response.sendRedirect(request.getContextPath() + "/forbidden");
            return false;
        }
        return true;
    }
}
