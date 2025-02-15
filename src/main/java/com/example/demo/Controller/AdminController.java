package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.BreakdownRequestService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private BreakdownRequestService breakdownRequestService;

    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        model.addAttribute("requests", breakdownRequestService.getAllRequests());
        return "admin_dashboard";
    }

    @PostMapping("/update-status/{id}")
    public String updateStatus(@PathVariable Long id, @RequestParam String status) {
        breakdownRequestService.updateRequestStatus(id, status);
        return "redirect:/admin/dashboard";
    }
}
