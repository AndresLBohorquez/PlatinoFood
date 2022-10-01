package com.platinosfood.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlatinoFoodController {

    @GetMapping("/login")
    public String goToLogin(Model model) {
        return "login";
    }

    @GetMapping("/sign-up")
    public String goToSignUp(Model model) {
        return "sign-up";
    }

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

    @GetMapping("/admin")
    public String goToAdmin(Model model) {
        return "/admin/index.html";
    }

    @GetMapping("/reservations/reservations-list")
    public String goToReservationsListAdmin(Model model) {
        return "/admin/reservations/reservations-list";
    }

    @GetMapping("/user")
    public String goToUser(Model model) {
        return "user/profile";
    }

    @GetMapping("/user-reservations")
    public String goToUserReservations(Model model) {
        return "user/user-reservations";
    }
}
