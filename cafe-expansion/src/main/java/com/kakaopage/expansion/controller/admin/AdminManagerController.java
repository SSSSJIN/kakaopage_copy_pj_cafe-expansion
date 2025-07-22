package com.kakaopage.expansion.controller.admin;

import com.kakaopage.expansion.domain.User;
import com.kakaopage.expansion.domain.Book;
import com.kakaopage.expansion.service.UserService;
import com.kakaopage.expansion.service.BookService;
import com.kakaopage.expansion.service.ManagerWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/manager")
public class AdminManagerController {

    @Autowired private UserService userService;
    @Autowired private BookService bookService;
    @Autowired private ManagerWorkService managerWorkService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("managers", userService.findManagers());
        return "admin/managerList";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("books", bookService.getAllBooks());
        return "admin/managerRegisterForm";
    }

    @PostMapping("/register")
    public String register(@RequestParam Long userId, @RequestParam Long bookId) {
        userService.promoteToManager(userId);
        managerWorkService.assignWork(userId, bookId);
        return "redirect:/admin/manager";
    }

    @PostMapping("/revoke")
    public String revoke(@RequestParam Long managerId) {
        userService.demoteManager(managerId);
        managerWorkService.removeAllWorks(managerId);
        return "redirect:/admin/manager";
    }
}
