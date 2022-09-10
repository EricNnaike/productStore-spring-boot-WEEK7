package com.urch.ecommercethymleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/navigateToAdmin")
    public String navigate() {
        return "dashboard";
    }
}
