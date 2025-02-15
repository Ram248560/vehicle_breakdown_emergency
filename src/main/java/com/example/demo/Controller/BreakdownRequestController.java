package com.example.demo.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.BreakdownRequest;
import com.example.demo.Entity.User;
import com.example.demo.Service.BreakdownRequestService;
import com.example.demo.Service.UserService;

@Controller
@RequestMapping("/breakdown")
public class BreakdownRequestController {
    @Autowired
    private BreakdownRequestService breakdownRequestService;
    @Autowired
    private UserService userService;

    @PostMapping("/request")
    public String submitRequest(@ModelAttribute BreakdownRequest request, Principal principal) {
        User user = userService.getUserByEmail(principal.getName()).orElse(null);
        if (user == null) return "redirect:/login";

        request.setUser(user);
        breakdownRequestService.createRequest(request);
        return "redirect:/users/dashboard";
    }
}
