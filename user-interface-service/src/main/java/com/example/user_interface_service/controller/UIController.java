package com.example.user_interface_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {
    @RequestMapping("/")
    public String returnHomePage() {
        return "forward:/homepage.html";
    }
}
