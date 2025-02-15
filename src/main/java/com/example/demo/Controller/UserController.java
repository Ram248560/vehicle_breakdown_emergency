package com.example.demo.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        userService.registerUser(user);
        model.addAttribute("message", "Registration successful! Please log in.");
        return "login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String userDashboard(Model model, Principal principal) {
        User user = userService.getUserByEmail(principal.getName()).orElse(null);
        if (user == null) return "redirect:/login";

        model.addAttribute("user", user);
        model.addAttribute("requests", user.getBreakdownRequests());
        return "user_dashboard";
    }
}
