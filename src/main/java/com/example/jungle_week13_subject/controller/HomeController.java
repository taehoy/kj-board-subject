package com.example.jungle_week13_subject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/register")
    public String userReg(){
        return "reg";
    }
}
