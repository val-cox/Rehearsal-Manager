package com.valentino.rehearsalmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String dashboard() {
        // just load the dashboard frame for now
        return "index";
    }
}
