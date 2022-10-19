package com.platinosfood.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlatinoFoodController {

    @GetMapping("/terms")
    public String goToTerms(Model model) {
        return "terms";
    }

    @GetMapping("/policy")
    public String goToPolicy(Model model) {
        return "policy";
    }

    @GetMapping("/forget-password")
    public String goToForgetPassword(Model model) {
        return "forget-password";
    }


    
}
