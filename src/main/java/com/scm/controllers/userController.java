package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class userController {
 
    //profile
    @GetMapping("/profile")
    public String profilehandler(){
        return "profile.html";
    }
 
    //dashboard
    @GetMapping("/dashboard")
    public String dashboardhandler(){
        return "dashboard.html";
    }
}